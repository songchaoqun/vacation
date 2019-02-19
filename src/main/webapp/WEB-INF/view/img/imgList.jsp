<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/13
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
    <link rel="shortcut icon" href="http://www.itmayiedu.com/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css"
          href="reset.css-t=2017-07-27.css" tppabs="http://www.itmayiedu.com/static/inxweb/css/reset.css?t=2017-07-27">
    <link rel="stylesheet" type="text/css"
          href="theme.css-t=2017-07-27.css" tppabs="http://www.itmayiedu.com/static/inxweb/css/theme.css?t=2017-07-27">
    <link rel="stylesheet" type="text/css"
          href="global.css-t=2017-07-27.css" tppabs="http://www.itmayiedu.com/static/inxweb/css/global.css?t=2017-07-27">
    <link rel="stylesheet" type="text/css"
          href="web.css-t=2017-07-27.css" tppabs="http://www.itmayiedu.com/static/inxweb/css/web.css?t=2017-07-27">
    <link rel="stylesheet" type="text/css"
          href="adaptive.css-t=2017-07-27.css" tppabs="http://www.itmayiedu.com/static/inxweb/css/adaptive.css?t=2017-07-27">
    <link href="mw_320_768.css-t=2017-07-27.css" tppabs="http://www.itmayiedu.com/static/inxweb/css/mw_320_768.css?t=2017-07-27" rel="stylesheet"
          type="text/css"
          media="screen and (min-width: 320px) and (max-width: 768px)">
    <!--[if lt IE 9]><script src="html5.js" tppabs="http://www.itmayiedu.com/static/common/html5.js"></script><![endif]-->
    <script type="text/javascript"
            src="jquery-1.7.2.min.js-t=2017-07-27" tppabs="http://www.itmayiedu.com/static/common/jquery-1.7.2.min.js?t=2017-07-27"></script>
    <script type="text/javascript" src="webutils.js-t=2017-04-30" tppabs="http://www.itmayiedu.com/static/common/webutils.js?t=2017-04-30"></script>
    <script type="text/javascript"
            src="header.js-t=2017-07-27" tppabs="http://www.itmayiedu.com/static/inxweb/header/header.js?t=2017-07-27"></script>
    <script type="text/javascript" src="common.js-t=2017-07-27" tppabs="http://www.itmayiedu.com/static/inxweb/js/common.js?t=2017-07-27"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "hm.js-b43c1c82b09cda6b125e6981fbde442c"/*tpa=https://hm.baidu.com/hm.js?b43c1c82b09cda6b125e6981fbde442c*/;
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <script>var baselocation = "index.htm"/*tpa=http://www.itmayiedu.com/*/;var keuploadSimpleUrl='http://www.itmayiedu.com/image/keupload?';var uploadServerUrl='index.htm'/*tpa=http://www.itmayiedu.com/*/;var uploadSimpleUrl="http://www.itmayiedu.com/image/gok4?";</script>
    <meta name="baidu-site-verification" content="td22YrPILf" />

    <script>
        var theme_color = 'orange';

    </script>

    <script type="text/javascript">
        $(document).ready(function() {
            var i = setInterval(function() {
                if ($(".in-wrap").next().is(":hidden")) {
                    clearTimeout(i);
                    $(".in-wrap").next().show();
                    //如果元素为隐藏,则将它显现
                } else {
                    $(".in-wrap").next().html('');
                    $(".in-wrap").next().hide(); //如果元素为显现,则将其隐藏
                }

            }, 1);

        });
    </script>
</head>
<body>
<div class="i-slide">
    <section>
        <!-- 如果需要导航按钮 -->
        <a class="arrow-left s-arrow" href="javascript:void(0)"></a> <a
            class="arrow-right s-arrow" href="javascript:void(0)"></a>
        <!-- 图片位置 -->
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide"
                     style="background: #fafafa;;">
                    <a target="_blank"
                       href="javascript:if(confirm('https://mp.weixin.qq.com/s?__biz=MzUzNDQwNTI5OA==&mid=2247483676&idx=1&sn=0ab157709cf2af77ef70271e19524ef6&chksm=fa9408c1cde381d7288816e4a4ed63b17e4159a0dc40afaa41321ca029ac91d4fd77cacd4b63&mpshare=1&scene=23&srcid=05112wBs5jvYfiOUSauwCBbH  \n\n���ļ��޷��� Teleport Ultra ����, ��Ϊ ����һ�����·���ⲿ������Ϊ������ʼ��ַ�ĵ�ַ��  \n\n�����ڷ������ϴ���?'))window.location='https://mp.weixin.qq.com/s?__biz=MzUzNDQwNTI5OA==&mid=2247483676&idx=1&sn=0ab157709cf2af77ef70271e19524ef6&chksm=fa9408c1cde381d7288816e4a4ed63b17e4159a0dc40afaa41321ca029ac91d4fd77cacd4b63&mpshare=1&scene=23&srcid=05112wBs5jvYfiOUSauwCBbH#rd'" tppabs="https://mp.weixin.qq.com/s?__biz=MzUzNDQwNTI5OA==&mid=2247483676&idx=1&sn=0ab157709cf2af77ef70271e19524ef6&chksm=fa9408c1cde381d7288816e4a4ed63b17e4159a0dc40afaa41321ca029ac91d4fd77cacd4b63&mpshare=1&scene=23&srcid=05112wBs5jvYfiOUSauwCBbH#rd">
                        <img class="imgload" src="${ctx}/images/4.jpg" tppabs="http://www.itmayiedu.com/images/upload/image/20180511/1525971349741.png"
                             alt="首页banner图片02">
                    </a>
                </div>
                <div class="swiper-slide"
                     style="background: #fafafa;;">
                    <a target="_blank"
                       href="javascript:if(confirm('https://ke.qq.com/course/273548?tuin=2663a60b  \n\n���ļ��޷��� Teleport Ultra ����, ��Ϊ ����һ�����·���ⲿ������Ϊ������ʼ��ַ�ĵ�ַ��  \n\n�����ڷ������ϴ���?'))window.location='https://ke.qq.com/course/273548?tuin=2663a60b'" tppabs="https://ke.qq.com/course/273548?tuin=2663a60b">
                        <img class="imgload" src="${ctx}/images/5.jpg" tppabs="http://www.itmayiedu.com/images/upload/image/20180511/1525971495193.png"
                             alt="首页banner图片04">
                    </a>
                </div>
                <div class="swiper-slide"
                     style="background: #fafafa;;">
                    <a target="_blank"
                       href="locaMemberRecharge.htm" tppabs="http://www.itmayiedu.com/lc/locaMemberRecharge">
                        <img class="imgload" src="${ctx}/images/2.jpg" tppabs="http://www.itmayiedu.com/images/upload/image/20180514/1526270493681.png"
                             alt="蚂蚁课堂VIP">
                    </a>
                </div>
            </div>
        </div>
        <!-- 如果需要分页器 -->
        <div class="pagination"></div>
    </section>
    <!-- <script type="text/javascript"
			src="http://www.itmayiedu.com/static/inxweb/js/adaptive.js"></script> -->
    <script type="text/javascript"
            src="swiper-2.1.0.js" tppabs="http://www.itmayiedu.com/static/inxweb/js/swiper-2.1.0.js"></script>
    <script type="text/javascript"
            src="index.js" tppabs="http://www.itmayiedu.com/static/inxweb/front/index.js"></script>
    <script type="text/javascript"
            src="index_theme_color.js" tppabs="http://www.itmayiedu.com/static/inxweb/front/index_theme_color.js"></script>
</div>
<section
        style="color: #666; position: absolute; left: 50%; bottom: 20px; z-index: 7; margin-left: -80px;">
    <script>(function (i, s, o, g, r, a, m) {
        i["DaoVoiceObject"] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o), m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        a.charset = "utf-8";
        m.parentNode.insertBefore(a, m)
    })(window, document, "script", ('https:' == document.location.protocol ? 'https:' : 'http:') + "//widget.daovoice.io/widget/3b2adbb4.js", "daovoice")</script>
    <script>
        function IsPC() {
            var userAgentInfo = navigator.userAgent;
            var Agents = ["Android", "iPhone",
                "SymbianOS", "Windows Phone",
                "iPad", "iPod"
            ];
            var flag = true;
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }

        var myerror = '';
        (function () {
            var bp = document.createElement('script');
            var curProtocol = window.location.protocol.split(':')[0];
            if (curProtocol === 'https') {
                bp.src = 'push.js'/*tpa=https://zz.bdstatic.com/linksubmit/push.js*/;
            } else {
                bp.src = 'push-1.js'/*tpa=http://push.zhanzhang.baidu.com/push.js*/;
            }
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(bp, s);
        })();

        $(function () {

            $('#close_im').bind('click', function () {
                $('#main-im').css("height", "0");
                $('#im_main').hide();
                $('#open_im').show();
            });
            $('#open_im').bind('click', function (e) {
                $('#main-im').css("height", "272");
                $('#im_main').show();
                $(this).hide();
            });
            $('.go-top').bind('click', function () {
                $(window).scrollTop(0);
            });
            $(".weixing-container").bind('mouseenter', function () {
                $('.weixing-show').show();
            })
            $(".weixing-container").bind('mouseleave', function () {
                $('.weixing-show').hide();
            });

            // if (!IsPC()) {
            //     $("#main-im").hide();
            // }
        });

        daovoice('init', {
            app_id: "3b2adbb4"
        });
        daovoice('update');
    </script>
</section>
</body>
</html>
