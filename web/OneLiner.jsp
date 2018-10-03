<%@page import = "java.io.*, java.util.Random" %>
<%!
    String fullFilePath = "";
    int LineItem = -1;
    String[] OneLiner = new String[59];

    public void jspInit() {

        ServletContext context = getServletContext();
        String guestFile = context.getInitParameter("guestFile");

        System.out.println("guestFile=" + guestFile);

        String pathSeparator = System.getProperty("file.separator");

        fullFilePath = context.getRealPath("/WEB-INF/") + pathSeparator + guestFile;
        System.out.println("fullFilePath=" + fullFilePath);

        try {
            InputStream is = context.getResourceAsStream("/WEB-INF/"+guestFile);
            if (is == null){
                System.out.println("This is null");
}
            if (is != null) {
                InputStreamReader streamread = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamread);
                String text;
                text = reader.readLine();   
                while (text != null) {
                    //writer.println(text + "</br>");
                    String newLine = text;
                    LineItem++;
                    OneLiner[LineItem] = newLine;
                    text = reader.readLine();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
%>
<html>
    <body>
        <form action = "OneLiner">
            <%Random rand = new Random();%>
            <%int r = rand.nextInt(59) + 0;%>
            <%=OneLiner[r]%>
            <br><br>click <a href = "OneLiner.jsp">Next</a> for new one liner

        </form>
    </body>
</html>

