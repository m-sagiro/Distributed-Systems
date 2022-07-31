<%@ page import="FundStock.Stock, FundStock.Fund" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body>
<form action="searchStockPOST.jsp" method="POST">
    Stock name:
    <label>
        <input type="text" name="stockname">
    </label>
    <br/>
    <input type="submit" value="Submit" />
    <%! int b=1;%>
    <%! int c=12;%>
    <% c++;%>
    <%=b++%>
    <p>Wert1: <%=b%></p>
    <p>Wert2: <%=c++%></p>
</form>
</body>
</html>