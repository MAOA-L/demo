<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理</title>
    <link href="/${freemarker.name}/css/bootstrap.min.css" rel="stylesheet">
    <link href="/${freemarker.name}/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- Toastr style -->
    <link href="/${freemarker.name}/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <!-- Gritter -->
    <link href="/${freemarker.name}/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="/${freemarker.name}/css/animate.css" rel="stylesheet">
    <link href="/${freemarker.name}/css/style.css" rel="stylesheet">
</head>

<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span>
                            <img alt="image" class="img-circle" src="/${freemarker.name}/img/profile_small.jpg" />
                        </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">用户名</strong>
                            </span> <span class="text-muted text-xs block">职位<b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">设置</a></li>
                            <li><a href="contacts.html">联系方式</a></li>
                            <li><a href="mailbox.html">邮箱</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">退出</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        MeeFo
                    </div>
                </li>
                <#--这里放菜单-->
                <li class="active">
                    <a href="index.html">
                        <i class="fa fa-th-large"></i>
                        <span class="nav-label">统计</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li class="active"><a href="index.html">仪表盘1</a></li>
                        <li><a href="dashboard_2.html">仪表盘2</a></li>
                    </ul>
                </li>
                <li>
                    <a href="index.html#">
                        <i class="fa fa-bar-chart-o"></i>
                        <span class="nav-label">这里就是two了</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="graph_flot.html">子菜单1</a></li>
                        <li><a href="graph_morris.html">子菜单2</a></li>
                    </ul>
                </li>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="javascript:void(0);">
                        <i class="fa fa-bars"></i>
                    </a>
                    <#--<form role="search" class="navbar-form-custom" action="search_results.html">-->
                        <#--<div class="form-group">-->
                            <#--<input type="text" placeholder="搜素" class="form-control" name="top-search" id="top-search">-->
                        <#--</div>-->
                    <#--</form>-->
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><!--欢迎标题-->米福云</span>
                    </li>
                    <#--以下为消息提醒-->
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                            <i class="fa fa-envelope"></i><span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46h ago</small>
                                        <strong>林女士</strong> 在什么地方 <strong>做什么</strong>. <br>
                                        <small class="text-muted">3 天前 at 7:58 pm - 10.06.2014</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>

                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html">
                                        <i class="fa fa-envelope"></i> <strong>查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <#--以下为事项提醒-->
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 你有16条消息提醒
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <#--<li>-->
                                <#--<a href="profile.html">-->
                                    <#--<div>-->
                                        <#--<i class="fa fa-twitter fa-fw"></i> 3 New Followers-->
                                        <#--<span class="pull-right text-muted small">12 minutes ago</span>-->
                                    <#--</div>-->
                                <#--</a>-->
                            <#--</li>-->
                            <#--<li class="divider"></li>-->
                            <#--<li>-->
                                <#--<a href="grid_options.html">-->
                                    <#--<div>-->
                                        <#--<i class="fa fa-upload fa-fw"></i> Server Rebooted-->
                                        <#--<span class="pull-right text-muted small">4 minutes ago</span>-->
                                    <#--</div>-->
                                <#--</a>-->
                            <#--</li>-->
                            <#--<li class="divider"></li>-->
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>查看所有提醒</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="logout">
                            <i class="fa fa-sign-out"></i> 登出
                        </a>
                    </li>
                    <li>
                        <a class="right-sidebar-toggle">
                            <i class="fa fa-tasks"></i>
                        </a>
                    </li>
                </ul>

            </nav>
        </div>
        <@block name="content">在banner.ftl中填入内容</@block>

    </div>
    <#-- 可放置聊天小工具small_chat.ftl <@block/> -->
    <#-- 可放置有部分配置等其他消息工具 right_slider.ftl <@block/> -->
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Flot -->
<script src="js/plugins/flot/jquery.flot.js"></script>
<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="js/plugins/flot/jquery.flot.spline.js"></script>
<script src="js/plugins/flot/jquery.flot.resize.js"></script>
<script src="js/plugins/flot/jquery.flot.pie.js"></script>

<!-- Peity -->
<script src="js/plugins/peity/jquery.peity.min.js"></script>
<script src="js/demo/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI -->
<script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- GITTER -->
<script src="js/plugins/gritter/jquery.gritter.min.js"></script>

<!-- Sparkline -->
<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

<!-- Sparkline demo data  -->
<script src="js/demo/sparkline-demo.js"></script>

<!-- ChartJS-->
<script src="js/plugins/chartJs/Chart.min.js"></script>

<!-- Toastr -->
<script src="js/plugins/toastr/toastr.min.js"></script>
<#--这里加上需要的js-->
<@block name="customJs"></@block>

<#--这里放置skinConfig.ftl可以设置页面的样式-->

</body>
</html>
