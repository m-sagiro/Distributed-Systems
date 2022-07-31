<%@ page import="FundStock.Stock, FundStock.Fund" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body>
<form action="addStockPOST.jsp" method="POST">
    Stock name:
    <label>
        <input type="text" name="stockname">
    </label>
    Stock dividend:
    <label>
        <input type="text" name="stockdividend">
    </label>
    Stock quantity:
    <label>
        <input type="text" name="stockquantity">
    </label>
    <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>