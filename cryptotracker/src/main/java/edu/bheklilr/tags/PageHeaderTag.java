package edu.bheklilr.tags;

import java.util.Optional;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.PageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class PageHeaderTag extends SimpleTagSupport {

    private static enum Tab {
        Home,
        History,
        Visualize;

        String getName() {
            switch (this) {
                case Home:      return "";
                case History:   return "history";
                case Visualize: return "visualize";
                default:        return "";
            }
        }

        String getDisplayName() {
            switch (this) {
                case Home:      return "Home";
                case History:   return "History";
                case Visualize: return "Visualize";
                default:        return "";
            }
        }

        static Optional<Tab> fromName(String tabName) {
            tabName = tabName.toLowerCase();
            if (tabName == "home")      return Optional.of(Home);
            if (tabName == "history")   return Optional.of(History);
            if (tabName == "visualize") return Optional.of(Visualize);
            return Optional.empty();
        }
    }

    private Tab activeTab;

    public PageHeaderTag() {
        this.activeTab = Tab.Home;
    }

    public void setActive(String active) {
        Optional<Tab> tab = Tab.fromName(active);
        if (tab.isPresent()) {
            this.activeTab = tab.get();
        }
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out = context.getOut();
        String contextPath = ((HttpServletRequest) ((PageContext) context).getRequest()).getContextPath();
        out.println(contextPath);
        out.println("<div class=\"page-header\">");
        out.println("  <div class=\"container\">");
        out.println("    <div class=\"row\" id=\"navbar\">");

        for (Tab tab: Tab.class.getEnumConstants()) {
            if (tab == this.activeTab) {
                out.println(String.format(
                    "      <div class=\"col-md-4 nav-link active\"><a href=\"%s/%s\">%s</a></div>",
                    contextPath, tab.getName(), tab.getDisplayName()
                ));
            } else {
                out.println(String.format(
                    "      <div class=\"col-md-4 nav-link\"><a href=\"%s/%s\">%s</a></div>",
                    contextPath, tab.getName(), tab.getDisplayName()
                ));
            }
        }
        out.println("    </div>");
        out.println("  </div>");
        out.println("</div>");
    }
}
