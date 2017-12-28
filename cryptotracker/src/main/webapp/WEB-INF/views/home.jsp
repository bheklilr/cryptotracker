<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cryptotracker</title>

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous"
              >
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css"/>

        <%@ taglib uri="https://bheklilr.com/jsp/tlds/crypto" prefix="crypto" %>
    </head>
    <body>
        <crypto:page-header active="home"/>
    </body>
</html>
