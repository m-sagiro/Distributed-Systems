<%@ page import="FundStock.Stock, FundStock.Fund, java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>
<%
    ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
    Fund fund = list.get((Integer) session.getAttribute("actualfund"));
    Stock stock = fund.getStockByName((String) request.getParameter("stockname"));
    stock.setStockQuantity(Integer.parseInt(request.getParameter("stockquantity")));

    session.setAttribute("funds", list);
    String result = "Quantity of " + stock.getStockName() + " was changed to " +
            stock.getStockQuantity() + " <br>";
    session.setAttribute("result", result);
    response.sendRedirect("tasks.jsp");
%>