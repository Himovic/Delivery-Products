package org.apache.jsp.administrateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Models.Supermarket;
import Functions.AdminFunction;

public final class administrateur_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Listes Supermarché A Confirmer</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    ");
 
        List<Supermarket> supermarket = AdminFunction.listSupermarketToConfirm();
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container mt-3\">\n");
      out.write("            <table class=\"table table-striped\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Nom résponsable</th>\n");
      out.write("                        <th>Prénom résponsable</th>\n");
      out.write("                        <th>Numéro résponsable</th>\n");
      out.write("                        <th>Nom supermarché</th>\n");
      out.write("                        <th>Adresse supermarché</th>\n");
      out.write("                        <th>Numéro suermarché</th>\n");
      out.write("                        <th>Confirmer</th>\n");
      out.write("                        <th>Annuler</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
for(int i=0; i<supermarket.size();i++){
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( supermarket.get(i).getAdministrators().get(0).getNom() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supermarket.get(i).getAdministrators().get(0).getPrenom() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supermarket.get(i).getAdministrators().get(0).getNumero() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supermarket.get(i).getNom() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supermarket.get(i).getAdresse() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( supermarket.get(i).getNumero() );
      out.write("</td>\n");
      out.write("                        <td><button type=\"button\" id=\"confirm-supermarket\" class=\"btn btn-primary\">Confirmer</button></td>\n");
      out.write("                        <td><button type=\"button\" id=\"delete-supermarket\" class=\"btn btn-danger\">Annuler</button></td>\n");
      out.write("                        <input type=\"hidden\" id=\"idSupermarket\" value=\"");
      out.print( supermarket.get(i).getId() );
      out.write("\"\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"confirmSupermarket.js\"></script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
