package org.apache.jsp.supermarket_002dconfirm_002dlogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.Supermarket;
import Functions.SupermarketFunction;

public final class accueil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t<title>Gestion du supermarché</title>\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/datepicker3.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/styles.css\" rel=\"stylesheet\">\n");
      out.write("\t\n");
      out.write("\t<!--Custom Font-->\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\n");
      out.write("\t<!--[if lt IE 9]>\n");
      out.write("\t<script src=\"js/html5shiv.js\"></script>\n");
      out.write("\t<script src=\"js/respond.min.js\"></script>\n");
      out.write("\t<![endif]-->\n");
      out.write("</head>\n");

    Object idSupermarket = request.getSession().getAttribute("idSupermarket");
    String ss = idSupermarket.toString();
    Supermarket supermarket = SupermarketFunction.getSupermarketFromId(Integer.valueOf(ss));

      out.write("\n");
      out.write("<body>\n");
      out.write("\t<nav class=\"navbar navbar-custom navbar-fixed-top\" role=\"navigation\">\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#sidebar-collapse\"><span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span></button>\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#\"><span>GERER DES</span>Produits et des factures</a>\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("\t\t\t\t\t\t<em class=\"fa fa-envelope\"></em><span class=\"label label-danger\">15</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-messages\">\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"dropdown-messages-box\"><a href=\"profile.html\" class=\"pull-left\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img alt=\"image\" class=\"img-circle\" src=\"http://placehold.it/40/30a5ff/fff\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"message-body\"><small class=\"pull-right\">3 mins ago</small>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br /><small class=\"text-muted\">1:24 pm - 25/03/2015</small></div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"dropdown-messages-box\"><a href=\"profile.html\" class=\"pull-left\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img alt=\"image\" class=\"img-circle\" src=\"http://placehold.it/40/30a5ff/fff\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"message-body\"><small class=\"pull-right\">1 hour ago</small>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\">New message from <strong>Jane Doe</strong>.</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br /><small class=\"text-muted\">12:27 pm - 25/03/2015</small></div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"all-button\"><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<em class=\"fa fa-inbox\"></em> <strong>All Messages</strong>\n");
      out.write("\t\t\t\t\t\t\t\t</a></div>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("\t\t\t\t\t\t<em class=\"fa fa-bell\"></em><span class=\"label label-info\">5</span>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-alerts\">\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<div><em class=\"fa fa-envelope\"></em> 1 New Message\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"pull-right text-muted small\">3 mins ago</span></div>\n");
      out.write("\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<div><em class=\"fa fa-heart\"></em> 12 New Likes\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"pull-right text-muted small\">4 mins ago</span></div>\n");
      out.write("\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<div><em class=\"fa fa-user\"></em> 5 New Followers\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"pull-right text-muted small\">4 mins ago</span></div>\n");
      out.write("\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div><!-- /.container-fluid -->\n");
      out.write("\t</nav>\n");
      out.write("\t<div id=\"sidebar-collapse\" class=\"col-sm-3 col-lg-2 sidebar\">\n");
      out.write("\t\t<div class=\"profile-sidebar\">\n");
      out.write("\t\t\t<div class=\"profile-userpic\">\n");
      out.write("\t\t\t\t<img src=\"http://placehold.it/50/30a5ff/fff\" class=\"img-responsive\" alt=\"\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"profile-usertitle\">\n");
      out.write("\t\t\t\t<div class=\"profile-usertitle-name\">");
      out.print( supermarket.getNom() );
      out.write("</div>\n");
      out.write("\t\t\t\t<div class=\"profile-usertitle-status\"><span class=\"indicator label-success\"></span>");
      out.print( supermarket.getAdresse() );
      out.write("</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"divider\"></div>\n");
      out.write("\t\t<ul class=\"nav menu\">\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"index.jsp\"><em class=\"fa fa-dashboard\">&nbsp;</em>Accueil</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"categorie.jsp\"><em class=\"fa fa-dashboard\">&nbsp;</em>Gérer les catégories</a></li>\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"products.jsp\"><em class=\"fa fa-dashboard\">&nbsp;</em>Gérer les produits</a></li>\n");
      out.write("\t\t\t<li class=\"parent \"><a data-toggle=\"collapse\" href=\"#sub-item-1\">\n");
      out.write("\t\t\t\t<em class=\"fa fa-navicon\">&nbsp;</em>Gestion des livraisons<span data-toggle=\"collapse\" href=\"#sub-item-1\" class=\"icon pull-right\"><em class=\"fa fa-plus\"></em></span>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t<ul class=\"children collapse\" id=\"sub-item-1\">\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"livreurs.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-arrow-right\">&nbsp;</span>Ajouter des livreurs\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"#\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-arrow-right\">&nbsp;</span>Confirmer les livraisons\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"#\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-arrow-right\">&nbsp;</span>Consulter les factures\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li><a href=\"#\"><em class=\"fa fa-power-off\">&nbsp;</em>Déconnecter</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div><!--/.sidebar-->\n");
      out.write("\t\t\n");
      out.write("\t<div class=\"col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main\">\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-lg-12\">\n");
      out.write("\t\t\t\t<h1 class=\"page-header\">Acceuil</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div><!--/.row-->\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"panel panel-container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-xs-6 col-md-3 col-lg-3 no-padding\">\n");
      out.write("\t\t\t\t\t<div class=\"panel panel-teal panel-widget border-right\">\n");
      out.write("\t\t\t\t\t\t<div class=\"row no-padding\"><em class=\"fa fa-xl fa-shopping-cart color-blue\"></em>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"large\">120</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text-muted\">Nombre de produits</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-xs-6 col-md-3 col-lg-3 no-padding\">\n");
      out.write("\t\t\t\t\t<div class=\"panel panel-blue panel-widget border-right\">\n");
      out.write("\t\t\t\t\t\t<div class=\"row no-padding\"><em class=\"fa fa-xl fa-comments color-orange\"></em>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"large\">52</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text-muted\">Produits commandés</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-xs-6 col-md-3 col-lg-3 no-padding\">\n");
      out.write("\t\t\t\t\t<div class=\"panel panel-orange panel-widget border-right\">\n");
      out.write("\t\t\t\t\t\t<div class=\"row no-padding\"><em class=\"fa fa-xl fa-users color-teal\"></em>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"large\">24</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text-muted\">Livraisons en attente</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-xs-6 col-md-3 col-lg-3 no-padding\">\n");
      out.write("\t\t\t\t\t<div class=\"panel panel-red panel-widget \">\n");
      out.write("\t\t\t\t\t\t<div class=\"row no-padding\"><em class=\"fa fa-xl fa-search color-red\"></em>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"large\">25</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text-muted\">Livraisons confirmées</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div><!--/.row-->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\n");
      out.write("\t</div>\t<!--/.main-->\n");
      out.write("\t\n");
      out.write("\t<script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\t<script src=\"js/chart.min.js\"></script>\n");
      out.write("\t<script src=\"js/chart-data.js\"></script>\n");
      out.write("\t<script src=\"js/easypiechart.js\"></script>\n");
      out.write("\t<script src=\"js/easypiechart-data.js\"></script>\n");
      out.write("\t<script src=\"js/bootstrap-datepicker.js\"></script>\n");
      out.write("\t<script src=\"js/custom.js\"></script>\n");
      out.write("\t<script>\n");
      out.write("\t\twindow.onload = function () {\n");
      out.write("\tvar chart1 = document.getElementById(\"line-chart\").getContext(\"2d\");\n");
      out.write("\twindow.myLine = new Chart(chart1).Line(lineChartData, {\n");
      out.write("\tresponsive: true,\n");
      out.write("\tscaleLineColor: \"rgba(0,0,0,.2)\",\n");
      out.write("\tscaleGridLineColor: \"rgba(0,0,0,.05)\",\n");
      out.write("\tscaleFontColor: \"#c5c7cc\"\n");
      out.write("\t});\n");
      out.write("};\n");
      out.write("\t</script>\n");
      out.write("\t\t\n");
      out.write("</body>\n");
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
