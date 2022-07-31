<%@ page import="FundStock.Stock, FundStock.Fund, java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>
<%
    Integer actual = (Integer) session.getAttribute("actualfund");
    ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
    list.get(actual).addStock(
            (String) request.getParameter("stockname"),
            Float.parseFloat((String) request.getParameter("stockdividend")),
            Integer.parseInt((String) request.getParameter("stockquantity")));

    session.setAttribute("funds", list);

    String result = "Stock added!<br>";
    session.setAttribute("result", result);
    response.sendRedirect("tasks.jsp");
%>