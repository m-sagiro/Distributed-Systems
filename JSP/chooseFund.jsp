<%@ page import="FundStock.Stock, FundStock.Fund" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body>
<form action="chooseFundPOST.jsp" method="POST">
    <label for="funds">Choose a Fund:</label>
    <select id="funds" name="funds">
        <%
            ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
            for(Fund fund: list){
        %>
        <option value="<%= fund.getFundName() %>"> <%= fund.getFundName() %> </option>
        <%}%>
    </select>

    <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>