<%@ page import="FundStock.Stock, FundStock.Fund, java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>
<%
    ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
    Integer actual = (Integer) session.getAttribute("actualfund");
    Fund fund = list.get(actual);
    StringBuilder result = new StringBuilder("List of all Stocks: <br>");
    for(Stock stock: fund.getAllStocks()){
        result.append("stock name: ").append(stock.getStockName()).append(" stock dividend: ")
                .append(stock.getStockDividend()).append(" stock quantity: ").append(stock.getStockQuantity())
                .append("<br>");
    }

    session.setAttribute("result", result.toString());
    response.sendRedirect("tasks.jsp");
%>