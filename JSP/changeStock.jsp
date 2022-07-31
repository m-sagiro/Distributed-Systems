<%@ page import="FundStock.Stock, FundStock.Fund" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body>
<form action="changeStockPOST.jsp" method="POST">
    <label for="stockname">Choose a Stock:</label>
    <select id="stockname" name="stockname">
        <%
            ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
            Fund fund = (Fund) list.get((Integer) session.getAttribute("actualfund"));
            for(Stock stock: fund.getAllStocks()){
        %>
        <option value="<%= stock.getStockName() %>"> <%= stock.getStockName() %> </option>
        <%}%>
    </select>

    <label>
        New stock quantity:
        <input type="text" name="stockquantity">
    </label>
    <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>