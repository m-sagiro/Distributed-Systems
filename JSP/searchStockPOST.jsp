<%@ page import="FundStock.Stock, FundStock.Fund, java.util.ArrayList" %>
<%
    Integer actual = (Integer) session.getAttribute("actualfund");
    ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
    Stock stock = list.get(actual).getStockByName(request.getParameter("stockname"));

    if(stock != null){
        String result = "Stock found!<br>Stock name: " + stock.getStockName() + "<br>stock dividend: " +
                stock.getStockDividend() + "<br>stock quantity: " + stock.getStockQuantity() + "<br>";
        session.setAttribute("result", result);
    }
    else {
        session.setAttribute("result", "No Stock found!<br>");
    }

    response.sendRedirect("tasks.jsp");
%>