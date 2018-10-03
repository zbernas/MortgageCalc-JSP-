<%@page import = "MyClasses.ArrayBuilder,java.util.Arrays,java.io.PrintWriter;" %>
<%
    double interest = Integer.parseInt(request.getParameter("interest"));
    double principal = Integer.parseInt(request.getParameter("principal"));
    double monthly = Integer.parseInt(request.getParameter("monthly"));
    int numMonths = Integer.parseInt(request.getParameter("numMonths")) * 12; 

    ArrayBuilder arr = new ArrayBuilder(interest, principal, monthly, numMonths);
    arr.setArray();
    arr.CalcLength();
    arr.makeArray();

    if (interest <= 0 || principal <= 0 || monthly <= 0 || numMonths <= 0){%>
                
                You did not enter enough information
                click <a href = "Mortgage.html"> here</a> to go back
                
            <%}
else {
%>
<font size = '5'>click <a href = "Mortgage.html"> here</a> to go back</font><br>
<h1><i><u>Interest Calculations</h1></u></i>
<h3>Calculating For: <br>
<h3>Interest rate/year: <%= interest%> <br>
<h3>Starting Principal: <%=principal%> <br>
<h3>Payment/Month: <%=monthly%> <br>
<h3>Years: <%= (numMonths/12)%> <br></h3>    
<br><table border = "1">
<tr><th>Month Number</th>
<th>Principal</th>
<th>Interest</th></tr>
            <%for(int i= 0; i < arr.getArrayLength()-1; i++){%>
                <tr><td> <%=(i + 1)%></td>
                <td> <%=ArrayBuilder.PrincipalArr[i]%></td>
                <td><%=ArrayBuilder.InterestArr[i]%></td></tr>
                <%}%>
                    </table>
            <%}%>
            Last Payment = <%=ArrayBuilder.PrincipalArr[arr.getArrayLength()-1]%><br>
            This includes interest at = <%=ArrayBuilder.InterestArr[arr.getArrayLength()-1]%>
