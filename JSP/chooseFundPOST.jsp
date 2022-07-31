<%@ page import="FundStock.Stock, FundStock.Fund, java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>
<%
    String requestFund = request.getParameter("funds");
    ArrayList<Fund> list = (ArrayList<Fund>) session.getAttribute("funds");
    Integer actual=null;
    for(int i=0; i<list.size(); i++){
        if(list.get(i).getFundName().equals(requestFund)){
            actual = i;
        }
    }

    session.setAttribute("actualfund", actual);
    String result = list.get(actual).getFundName() + " is now choosen<br>";
    session.setAttribute("result", result);
    response.sendRedirect("tasks.jsp");
%>