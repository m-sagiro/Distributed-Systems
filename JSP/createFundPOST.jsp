<%@ page import="FundStock.Stock, FundStock.Fund, java.util.ArrayList" %>
<%
    if (session.getAttribute("funds") == null){
        ArrayList<Fund> list = new ArrayList<>();
        Fund fund = new Fund(request.getParameter("fundname"));
        list.add(fund);
        int actual = list.size();
        session.setAttribute("funds", list);
        session.setAttribute("actualfund", --actual);
        session.setAttribute("result", "A new Fund is created!<br>");
    }
    else {
        Fund fund = new Fund(request.getParameter("fundname"));
        ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
        list.add(fund);
        session.setAttribute("funds", list);
        session.setAttribute("result", "A new Fund is created!<br>");
    }
    response.sendRedirect("tasks.jsp");
%>