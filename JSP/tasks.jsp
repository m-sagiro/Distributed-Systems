<%@ page import="FundStock.Stock, FundStock.Fund" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>
<html>
    <body>
        <%
            String result = (String) session.getAttribute("result");
            if(result != null) {
                out.print(result);
                out.println("<br>");
                session.removeAttribute("result");
            }
        %>
        <br>
        <% if(session.getAttribute("actualfund") == null) {%>
        Current Fund: No Fund available yet! Create a new one first!
        <p><a href="createFund.jsp">Create Fund</a></p>
        <%} else{ %>
        <%
            ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
            Fund fund = list.get((int) session.getAttribute("actualfund"));

        %>
        Current Fund: <%= fund.getFundName()%>
        <p><a href="createFund.jsp">Create Fund</a></p>
        <p><a href="chooseFund.jsp">Choose Fund</a></p>
        <p><a href="searchStock.jsp">Search Stock</a></p>
        <p><a href="addStock.jsp">Add new Stock</a></p>
        <p><a href="showStocks.jsp">Show all Stocks</a></p>
        <p><a href="changeStock.jsp">Change quantity of a Stock</a></p>
        <%}%>

        <p><a href="deleteSession.jsp">Delete session</a></p>

    </body>
</html>