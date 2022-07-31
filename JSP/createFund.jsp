<%@ page import="FundStock.Stock, FundStock.Fund" %>
<html>
<body>
<form action="createFundPOST.jsp" method="POST">
    Fund name:
    <label>
        <input type="text" name="fundname">
    </label>
    <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>