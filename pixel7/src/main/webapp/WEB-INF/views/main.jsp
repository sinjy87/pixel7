<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script language="javascript">
            // 해당이름의 쿠키를 가져온다.
            function getCookie(cookie_name) {
                var isCookie = false;
                var start, end;
                var i = 0;

                // cookie 문자열 전체를 검색
                while(i <= document.cookie.length) {
                     start = i;
                     end = start + cookie_name.length;
                     // cookie_name과 동일한 문자가 있다면
                     if(document.cookie.substring(start, end) == cookie_name) {
                         isCookie = true;
                         break;
                     }
                     i++;
                }

                // cookie_name 문자열을 cookie에서 찾았다면
                if(isCookie) {
                    start = end + 1;
                    end = document.cookie.indexOf(";", start);
                    // 마지막 부분이라는 것을 의미(마지막에는 ";"가 없다)
                    if(end < start)
                        end = document.cookie.length;
                    // cookie_name에 해당하는 value값을 추출하여 리턴한다.
                    return document.cookie.substring(start, end);
                }
                // 찾지 못했다면
                return "";
            }


function openMsgBox()
{
        var eventCookie=getCookie("event_condo");
        // 쿠키가 없을 경우에만 (다시 보지 않기를 선택하지 않았을 경우.)
        if (eventCookie != "no")
            window.open('pop','_blank','width=500,height=450,top=100,left=500');
}
openMsgBox();   // 팝업창을 띄운다.
</SCRIPT>  


<style>
.jssorb01 {
	position: absolute
}

.jssorb01 div, .jssorb01 div:hover, .jssorb01 .av {
	position: absolute;
	width: 12px;
	height: 12px;
	filter: alpha(opacity = 70);
	opacity: .7;
	overflow: hidden;
	cursor: pointer;
	border: #000 1px solid
}

.jssorb01 div {
	background-color: gray
}

.jssorb01 div:hover, .jssorb01 .av:hover {
	background-color: #d3d3d3
}

.jssorb01 .av {
	background-color: #fff
}

.jssorb01 .dn, .jssorb01 .dn:hover {
	background-color: #555
}

.jssora05l, .jssora05r {
	display: block;
	position: absolute;
	width: 40px;
	height: 40px;
	cursor: pointer;
	background: url('img/a17.png') no-repeat;
	overflow: hidden
}

.jssora05l {
	background-position: -10px -40px
}

.jssora05r {
	background-position: -70px -40px
}

.jssora05l:hover {
	background-position: -130px -40px
}

.jssora05r:hover {
	background-position: -190px -40px
}

.jssora05l.jssora05ldn {
	background-position: -250px -40px
}

.jssora05r.jssora05rdn {
	background-position: -310px -40px
}

.jssora05l.jssora05lds {
	background-position: -10px -40px;
	opacity: .3;
	pointer-events: none
}

.jssora05r.jssora05rds {
	background-position: -70px -40px;
	opacity: .3;
	pointer-events: none
}

.jssort09-600-45 .p {
	position: absolute;
	top: 0;
	left: 0;
	width: 600px;
	height: 45px
}

.jssort09-600-45 .t {
	font-family: verdana;
	font-weight: normal;
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	color: #fff;
	line-height: 45px;
	font-size: 20px;
	padding-left: 10px
}
</style>

<script type="text/javascript">
(function(f,g,c,i,e,k,h){/*! Jssor */
var u=new function(){this.af=e;this.wf=function(b){var a=this.af;a&&b()}},d={cd:function(a){return-c.cos(a*c.PI)/2+.5},Yb:function(a){return a},gf:function(a){return-a*(a-2)},dd:function(a){return a*a*a}};var b=new function(){var j=this,xb=/\S+/g,F=1,wb=2,cb=3,bb=4,fb=5,G,r=0,l=0,s=0,Y=0,A=0,I=navigator,kb=I.appName,o=I.userAgent,p=parseFloat;function Fb(){if(!G){G={xf:"ontouchstart"in f||"createTouch"in g};var a;if(I.pointerEnabled||(a=I.msPointerEnabled))G.xd=a?"msTouchAction":"touchAction"}return G}function v(i){if(!r){r=-1;if(kb=="Microsoft Internet Explorer"&&!!f.attachEvent&&!!f.ActiveXObject){var e=o.indexOf("MSIE");r=F;s=p(o.substring(e+5,o.indexOf(";",e)));/*@cc_on Y=@_jscript_version@*/;l=g.documentMode||s}else if(kb=="Netscape"&&!!f.addEventListener){var d=o.indexOf("Firefox"),b=o.indexOf("Safari"),h=o.indexOf("Chrome"),c=o.indexOf("AppleWebKit");if(d>=0){r=wb;l=p(o.substring(d+8))}else if(b>=0){var j=o.substring(0,b).lastIndexOf("/");r=h>=0?bb:cb;l=p(o.substring(j+1,b))}else{var a=/Trident\/.*rv:([0-9]{1,}[\.0-9]{0,})/i.exec(o);if(a){r=F;l=s=p(a[1])}}if(c>=0)A=p(o.substring(c+12))}else{var a=/(opera)(?:.*version|)[ \/]([\w.]+)/i.exec(o);if(a){r=fb;l=p(a[2])}}}return i==r}function q(){return v(F)}function vb(){return q()&&(l<6||g.compatMode=="BackCompat")}function ab(){return v(cb)}function eb(){return v(fb)}function rb(){return ab()&&A>534&&A<535}function J(){v();return A>537||l>42||r==F&&l>=11}function tb(){return q()&&l<9}function sb(a){var b,c;return function(f){if(!b){b=e;var d=a.substr(0,1).toUpperCase()+a.substr(1);n([a].concat(["WebKit","ms","Moz","O","webkit"]),function(g,e){var b=a;if(e)b=g+d;if(f.style[b]!=h)return c=b})}return c}}function qb(b){var a;return function(c){a=a||sb(b)(c)||b;return a}}var K=qb("transform");function jb(a){return{}.toString.call(a)}var gb={};n(["Boolean","Number","String","Function","Array","Date","RegExp","Object"],function(a){gb["[object "+a+"]"]=a.toLowerCase()});function n(b,d){var a,c;if(jb(b)=="[object Array]"){for(a=0;a<b.length;a++)if(c=d(b[a],a,b))return c}else for(a in b)if(c=d(b[a],a,b))return c}function D(a){return a==i?String(a):gb[jb(a)]||"object"}function hb(a){for(var b in a)return e}function B(a){try{return D(a)=="object"&&!a.nodeType&&a!=a.window&&(!a.constructor||{}.hasOwnProperty.call(a.constructor.prototype,"isPrototypeOf"))}catch(b){}}function u(a,b){return{x:a,y:b}}function nb(b,a){setTimeout(b,a||0)}function H(b,d,c){var a=!b||b=="inherit"?"":b;n(d,function(c){var b=c.exec(a);if(b){var d=a.substr(0,b.index),e=a.substr(b.index+b[0].length+1,a.length-1);a=d+e}});a=c+(!a.indexOf(" ")?"":" ")+a;return a}function pb(b,a){if(l<9)b.style.filter=a}j.uf=Fb;j.Ld=q;j.tf=ab;j.Kd=eb;j.sf=J;j.Kb=tb;sb("transform");j.Dd=function(){return l};j.rf=function(){v();return A};j.Lb=nb;function V(a){a.constructor===V.caller&&a.rd&&a.rd.apply(a,V.caller.arguments)}j.rd=V;j.kb=function(a){if(j.qf(a))a=g.getElementById(a);return a};function t(a){return a||f.event}j.td=t;j.nc=function(b){b=t(b);var a=b.target||b.srcElement||g;if(a.nodeType==3)a=j.wd(a);return a};j.Ad=function(a){a=t(a);return{x:a.pageX||a.clientX||0,y:a.pageY||a.clientY||0}};function w(c,d,a){if(a!==h)c.style[d]=a==h?"":a;else{var b=c.currentStyle||c.style;a=b[d];if(a==""&&f.getComputedStyle){b=c.ownerDocument.defaultView.getComputedStyle(c,i);b&&(a=b.getPropertyValue(d)||b[d])}return a}}function X(b,c,a,d){if(a!==h){if(a==i)a="";else d&&(a+="px");w(b,c,a)}else return p(w(b,c))}function m(c,a){var d=a?X:w,b;if(a&4)b=qb(c);return function(e,f){return d(e,b?b(e):c,f,a&2)}}function Ab(b){if(q()&&s<9){var a=/opacity=([^)]*)/.exec(b.style.filter||"");return a?p(a[1])/100:1}else return p(b.style.opacity||"1")}function Cb(b,a,f){if(q()&&s<9){var h=b.style.filter||"",i=new RegExp(/[\s]*alpha\([^\)]*\)/g),e=c.round(100*a),d="";if(e<100||f)d="alpha(opacity="+e+") ";var g=H(h,[i],d);pb(b,g)}else b.style.opacity=a==1?"":c.round(a*100)/100}var L={O:["rotate"],V:["rotateX"],Y:["rotateY"],bc:["skewX"],ac:["skewY"]};if(!J())L=C(L,{J:["scaleX",2],B:["scaleY",2],Q:["translateZ",1]});function M(d,a){var c="";if(a){if(q()&&l&&l<10){delete a.V;delete a.Y;delete a.Q}b.f(a,function(d,b){var a=L[b];if(a){var e=a[1]||0;if(N[b]!=d)c+=" "+a[0]+"("+d+(["deg","px",""])[e]+")"}});if(J()){if(a.mb||a.nb||a.Q!=h)c+=" translate3d("+(a.mb||0)+"px,"+(a.nb||0)+"px,"+(a.Q||0)+"px)";if(a.J==h)a.J=1;if(a.B==h)a.B=1;if(a.J!=1||a.B!=1)c+=" scale3d("+a.J+", "+a.B+", 1)"}}d.style[K(d)]=c}j.Rc=m("transformOrigin",4);j.pf=m("backfaceVisibility",4);j.of=m("transformStyle",4);j.nf=m("perspective",6);j.vf=m("perspectiveOrigin",4);j.mf=function(a,b){if(q()&&s<9||s<10&&vb())a.style.zoom=b==1?"":b;else{var c=K(a),f="scale("+b+")",e=a.style[c],g=new RegExp(/[\s]*scale\(.*?\)/g),d=H(e,[g],f);a.style[c]=d}};j.gc=function(b,a){return function(c){c=t(c);var e=c.type,d=c.relatedTarget||(e=="mouseout"?c.toElement:c.fromElement);(!d||d!==a&&!j.kf(a,d))&&b(c)}};j.c=function(a,d,b,c){a=j.kb(a);if(a.addEventListener){d=="mousewheel"&&a.addEventListener("DOMMouseScroll",b,c);a.addEventListener(d,b,c)}else if(a.attachEvent){a.attachEvent("on"+d,b);c&&a.setCapture&&a.setCapture()}};j.T=function(a,c,d,b){a=j.kb(a);if(a.removeEventListener){c=="mousewheel"&&a.removeEventListener("DOMMouseScroll",d,b);a.removeEventListener(c,d,b)}else if(a.detachEvent){a.detachEvent("on"+c,d);b&&a.releaseCapture&&a.releaseCapture()}};j.dc=function(a){a=t(a);a.preventDefault&&a.preventDefault();a.cancel=e;a.returnValue=k};j.jf=function(a){a=t(a);a.stopPropagation&&a.stopPropagation();a.cancelBubble=e};j.I=function(d,c){var a=[].slice.call(arguments,2),b=function(){var b=a.concat([].slice.call(arguments,0));return c.apply(d,b)};return b};j.hf=function(a,b){if(b==h)return a.textContent||a.innerText;var c=g.createTextNode(b);j.qc(a);a.appendChild(c)};j.Wb=function(d,c){for(var b=[],a=d.firstChild;a;a=a.nextSibling)(c||a.nodeType==1)&&b.push(a);return b};function ib(a,c,e,b){b=b||"u";for(a=a?a.firstChild:i;a;a=a.nextSibling)if(a.nodeType==1){if(S(a,b)==c)return a;if(!e){var d=ib(a,c,e,b);if(d)return d}}}j.q=ib;function Q(a,d,f,b){b=b||"u";var c=[];for(a=a?a.firstChild:i;a;a=a.nextSibling)if(a.nodeType==1){S(a,b)==d&&c.push(a);if(!f){var e=Q(a,d,f,b);if(e.length)c=c.concat(e)}}return c}function db(a,c,d){for(a=a?a.firstChild:i;a;a=a.nextSibling)if(a.nodeType==1){if(a.tagName==c)return a;if(!d){var b=db(a,c,d);if(b)return b}}}j.ff=db;function ub(a,c,e){var b=[];for(a=a?a.firstChild:i;a;a=a.nextSibling)if(a.nodeType==1){(!c||a.tagName==c)&&b.push(a);if(!e){var d=ub(a,c,e);if(d.length)b=b.concat(d)}}return b}j.ef=ub;j.df=function(b,a){return b.getElementsByTagName(a)};function C(){var e=arguments,d,c,b,a,g=1&e[0],f=1+g;d=e[f-1]||{};for(;f<e.length;f++)if(c=e[f])for(b in c){a=c[b];if(a!==h){a=c[b];var i=d[b];d[b]=g&&(B(i)||B(a))?C(g,{},i,a):a}}return d}j.v=C;function W(f,g){var d={},c,a,b;for(c in f){a=f[c];b=g[c];if(a!==b){var e;if(B(a)&&B(b)){a=W(a,b);e=!hb(a)}!e&&(d[c]=a)}}return d}j.md=function(a){return D(a)=="function"};j.qf=function(a){return D(a)=="string"};j.Xc=function(a){return!isNaN(p(a))&&isFinite(a)};j.f=n;j.lf=B;function P(a){return g.createElement(a)}j.sb=function(){return P("DIV")};j.cf=function(){return P("SPAN")};j.ld=function(){};function T(b,c,a){if(a==h)return b.getAttribute(c);b.setAttribute(c,a)}function S(a,b){return T(a,b)||T(a,"data-"+b)}j.A=T;j.k=S;function y(b,a){if(a==h)return b.className;b.className=a}j.Wc=y;function mb(b){var a={};n(b,function(b){if(b!=h)a[b]=b});return a}function ob(b,a){return b.match(a||xb)}function O(b,a){return mb(ob(b||"",a))}j.Bf=ob;function Z(b,c){var a="";n(c,function(c){a&&(a+=b);a+=c});return a}function E(a,c,b){y(a,Z(" ",C(W(O(y(a)),O(c)),O(b))))}j.wd=function(a){return a.parentNode};j.P=function(a){j.gb(a,"none")};j.u=function(a,b){j.gb(a,b?"none":"")};j.Ef=function(b,a){b.removeAttribute(a)};j.Af=function(){return q()&&l<10};j.Df=function(d,a){if(a)d.style.clip="rect("+c.round(a.i||a.G||0)+"px "+c.round(a.n)+"px "+c.round(a.p)+"px "+c.round(a.g||a.C||0)+"px)";else if(a!==h){var g=d.style.cssText,f=[new RegExp(/[\s]*clip: rect\(.*?\)[;]?/i),new RegExp(/[\s]*cliptop: .*?[;]?/i),new RegExp(/[\s]*clipright: .*?[;]?/i),new RegExp(/[\s]*clipbottom: .*?[;]?/i),new RegExp(/[\s]*clipleft: .*?[;]?/i)],e=H(g,f,"");b.Zb(d,e)}};j.db=function(){return+new Date};j.E=function(b,a){b.appendChild(a)};j.Sb=function(b,a,c){(c||a.parentNode).insertBefore(b,a)};j.ub=function(b,a){a=a||b.parentNode;a&&a.removeChild(b)};j.yf=function(a,b){n(a,function(a){j.ub(a,b)})};j.qc=function(a){j.yf(j.Wb(a,e),a)};j.zf=function(a,b){var c=j.wd(a);b&1&&j.F(a,(j.l(c)-j.l(a))/2);b&2&&j.D(a,(j.m(c)-j.m(a))/2)};j.bf=function(b,a){return parseInt(b,a||10)};j.Cf=p;j.kf=function(b,a){var c=g.body;while(a&&b!==a&&c!==a)try{a=a.parentNode}catch(d){return k}return b===a};function U(d,c,b){var a=d.cloneNode(!c);!b&&j.Ef(a,"id");return a}j.cb=U;j.Cb=function(d,f){var a=new Image;function b(e,d){j.T(a,"load",b);j.T(a,"abort",c);j.T(a,"error",c);f&&f(a,d)}function c(a){b(a,e)}if(eb()&&l<11.6||!d)b(!d);else{j.c(a,"load",b);j.c(a,"abort",c);j.c(a,"error",c);a.src=d}};j.Vd=function(d,a,e){var c=d.length+1;function b(b){c--;if(a&&b&&b.src==a.src)a=b;!c&&e&&e(a)}n(d,function(a){j.Cb(a.src,b)});b()};j.ad=function(a,g,i,h){if(h)a=U(a);var c=Q(a,g);if(!c.length)c=b.df(a,g);for(var f=c.length-1;f>-1;f--){var d=c[f],e=U(i);y(e,y(d));b.Zb(e,d.style.cssText);b.Sb(e,d);b.ub(d)}return a};function Db(a){var l=this,p="",r=["av","pv","ds","dn"],e=[],q,k=0,f=0,d=0;function i(){E(a,q,e[d||k||f&2||f]);b.R(a,"pointer-events",d?"none":"")}function c(){k=0;i();j.T(g,"mouseup",c);j.T(g,"touchend",c);j.T(g,"touchcancel",c)}function o(a){if(d)j.dc(a);else{k=4;i();j.c(g,"mouseup",c);j.c(g,"touchend",c);j.c(g,"touchcancel",c)}}l.bd=function(a){if(a===h)return f;f=a&2||a&1;i()};l.Ub=function(a){if(a===h)return!d;d=a?0:3;i()};l.lb=a=j.kb(a);var m=b.Bf(y(a));if(m)p=m.shift();n(r,function(a){e.push(p+a)});q=Z(" ",e);e.unshift("");j.c(a,"mousedown",o);j.c(a,"touchstart",o)}j.Xb=function(a){return new Db(a)};j.R=w;j.ob=m("overflow");j.D=m("top",2);j.F=m("left",2);j.l=m("width",2);j.m=m("height",2);j.sc=m("marginLeft",2);j.mc=m("marginTop",2);j.s=m("position");j.gb=m("display");j.L=m("zIndex",1);j.Ab=function(b,a,c){if(a!=h)Cb(b,a,c);else return Ab(b)};j.Zb=function(a,b){if(b!=h)a.style.cssText=b;else return a.style.cssText};j.Pd=function(b,a){if(a===h){a=w(b,"backgroundImage")||"";var c=/\burl\s*\(\s*["']?([^"'\r\n,]+)["']?\s*\)/gi.exec(a)||[];return c[1]}w(b,"backgroundImage",a?"url('"+a+"')":"")};var R={z:j.Ab,i:j.D,g:j.F,hb:j.l,fb:j.m,wb:j.s,Lf:j.gb,S:j.L};function x(f,l){var e=tb(),b=J(),d=rb(),g=K(f);function k(b,d,a){var e=b.tb(u(-d/2,-a/2)),f=b.tb(u(d/2,-a/2)),g=b.tb(u(d/2,a/2)),h=b.tb(u(-d/2,a/2));b.tb(u(300,300));return u(c.min(e.x,f.x,g.x,h.x)+d/2,c.min(e.y,f.y,g.y,h.y)+a/2)}function a(d,a){a=a||{};var n=a.Q||0,p=(a.V||0)%360,q=(a.Y||0)%360,u=(a.O||0)%360,l=a.J,m=a.B,f=a.Mf;if(l==h)l=1;if(m==h)m=1;if(f==h)f=1;if(e){n=0;p=0;q=0;f=0}var c=new zb(a.mb,a.nb,n);c.V(p);c.Y(q);c.Je(u);c.Ke(a.bc,a.ac);c.fc(l,m,f);if(b){c.pb(a.C,a.G);d.style[g]=c.Me()}else if(!Y||Y<9){var o="",i={x:0,y:0};if(a.Z)i=k(c,a.Z,a.rb);j.mc(d,i.y);j.sc(d,i.x);o=c.Qe();var s=d.style.filter,t=new RegExp(/[\s]*progid:DXImageTransform\.Microsoft\.Matrix\([^\)]*\)/g),r=H(s,[t],o);pb(d,r)}}x=function(e,c){c=c||{};var g=c.C,k=c.G,f;n(R,function(a,b){f=c[b];f!==h&&a(e,f)});j.Df(e,c.a);if(!b){g!=h&&j.F(e,(c.Tc||0)+g);k!=h&&j.D(e,(c.Sc||0)+k)}if(c.Te)if(d)nb(j.I(i,M,e,c));else a(e,c)};j.qb=M;if(d)j.qb=x;if(e)j.qb=a;else if(!b)a=M;j.M=x;x(f,l)}j.qb=x;j.M=x;function zb(j,k,o){var d=this,b=[1,0,0,0,0,1,0,0,0,0,1,0,j||0,k||0,o||0,1],h=c.sin,g=c.cos,l=c.tan;function f(a){return a*c.PI/180}function n(a,b){return{x:a,y:b}}function m(c,e,l,m,o,r,t,u,w,z,A,C,E,b,f,k,a,g,i,n,p,q,s,v,x,y,B,D,F,d,h,j){return[c*a+e*p+l*x+m*F,c*g+e*q+l*y+m*d,c*i+e*s+l*B+m*h,c*n+e*v+l*D+m*j,o*a+r*p+t*x+u*F,o*g+r*q+t*y+u*d,o*i+r*s+t*B+u*h,o*n+r*v+t*D+u*j,w*a+z*p+A*x+C*F,w*g+z*q+A*y+C*d,w*i+z*s+A*B+C*h,w*n+z*v+A*D+C*j,E*a+b*p+f*x+k*F,E*g+b*q+f*y+k*d,E*i+b*s+f*B+k*h,E*n+b*v+f*D+k*j]}function e(c,a){return m.apply(i,(a||b).concat(c))}d.fc=function(a,c,d){if(a!=1||c!=1||d!=1)b=e([a,0,0,0,0,c,0,0,0,0,d,0,0,0,0,1])};d.pb=function(a,c,d){b[12]+=a||0;b[13]+=c||0;b[14]+=d||0};d.V=function(c){if(c){a=f(c);var d=g(a),i=h(a);b=e([1,0,0,0,0,d,i,0,0,-i,d,0,0,0,0,1])}};d.Y=function(c){if(c){a=f(c);var d=g(a),i=h(a);b=e([d,0,-i,0,0,1,0,0,i,0,d,0,0,0,0,1])}};d.Je=function(c){if(c){a=f(c);var d=g(a),i=h(a);b=e([d,i,0,0,-i,d,0,0,0,0,1,0,0,0,0,1])}};d.Ke=function(a,c){if(a||c){j=f(a);k=f(c);b=e([1,l(k),0,0,l(j),1,0,0,0,0,1,0,0,0,0,1])}};d.tb=function(c){var a=e(b,[1,0,0,0,0,1,0,0,0,0,1,0,c.x,c.y,0,1]);return n(a[12],a[13])};d.Me=function(){return"matrix3d("+b.join(",")+")"};d.Qe=function(){return"progid:DXImageTransform.Microsoft.Matrix(M11="+b[0]+", M12="+b[4]+", M21="+b[1]+", M22="+b[5]+", SizingMethod='auto expand')"}}new function(){var a=this;function b(d,g){for(var j=d[0].length,i=d.length,h=g[0].length,f=[],c=0;c<i;c++)for(var k=f[c]=[],b=0;b<h;b++){for(var e=0,a=0;a<j;a++)e+=d[c][a]*g[a][b];k[b]=e}return f}a.J=function(b,c){return a.Kc(b,c,0)};a.B=function(b,c){return a.Kc(b,0,c)};a.Kc=function(a,c,d){return b(a,[[c,0],[0,d]])};a.tb=function(d,c){var a=b(d,[[c.x],[c.y]]);return u(a[0][0],a[1][0])}};var N={Tc:0,Sc:0,C:0,G:0,H:1,J:1,B:1,O:0,V:0,Y:0,mb:0,nb:0,Q:0,bc:0,ac:0};j.Ic=function(c,d){var a=c||{};if(c)if(b.md(c))a={X:a};else if(b.md(c.a))a.a={X:c.a};a.X=a.X||d;if(a.a)a.a.X=a.a.X||d;return a};j.Mc=function(l,m,x,q,z,A,n){var a=m;if(l){a={};for(var g in m){var B=A[g]||1,w=z[g]||[0,1],f=(x-w[0])/w[1];f=c.min(c.max(f,0),1);f=f*B;var u=c.floor(f);if(f!=u)f-=u;var j=q.X||d.Yb,k,C=l[g],o=m[g];if(b.Xc(o)){j=q[g]||j;var y=j(f);k=C+o*y}else{k=b.v({ec:{}},l[g]);var v=q[g]||{};b.f(o.ec||o,function(d,a){j=v[a]||v.X||j;var c=j(f),b=d*c;k.ec[a]=b;k[a]+=b})}a[g]=k}var t=b.f(m,function(b,a){return N[a]!=h});t&&b.f(N,function(c,b){if(a[b]==h&&l[b]!==h)a[b]=l[b]});if(t){if(a.H)a.J=a.B=a.H;a.Z=n.Z;a.rb=n.rb;a.Te=e}}if(m.a&&n.pb){var p=a.a.ec,s=(p.i||0)+(p.p||0),r=(p.g||0)+(p.n||0);a.g=(a.g||0)+r;a.i=(a.i||0)+s;a.a.g-=r;a.a.n-=r;a.a.i-=s;a.a.p-=s}if(a.a&&b.Af()&&!a.a.i&&!a.a.g&&!a.a.G&&!a.a.C&&a.a.n==n.Z&&a.a.p==n.rb)a.a=i;return a}};function m(){var a=this,d=[];function i(a,b){d.push({ic:a,pc:b})}function h(a,c){b.f(d,function(b,e){b.ic==a&&b.pc===c&&d.splice(e,1)})}a.Bb=a.addEventListener=i;a.removeEventListener=h;a.j=function(a){var c=[].slice.call(arguments,1);b.f(d,function(b){b.ic==a&&b.pc.apply(f,c)})}}var l=function(B,F,h,K,N,M){B=B||0;var a=this,q,n,o,u,D=0,H,I,G,E,A=0,j=0,m=0,z,l,d,g,p,y,w=[],x;function P(a){d+=a;g+=a;l+=a;j+=a;m+=a;A+=a}function t(o){var f=o;if(p)if(!y&&(f>=g||f<d)||y&&f>=d)f=((f-d)%p+p)%p+d;if(!z||u||j!=f){var i=c.min(f,g);i=c.max(i,d);if(!z||u||i!=m){if(M){var k=(i-l)/(F||1);if(h.Pc)k=1-k;var n=b.Mc(N,M,k,H,G,I,h);if(x)b.f(n,function(b,a){x[a]&&x[a](K,b)});else b.M(K,n)}a.jc(m-l,i-l);var r=m,q=m=i;b.f(w,function(b,c){var a=!z&&y||f<=j?w[w.length-c-1]:b;a.W(m-A)});j=f;z=e;a.Qb(r,q)}}}function C(a,b,e){b&&a.Ib(g);if(!e){d=c.min(d,a.zd()+A);g=c.max(g,a.oc()+A)}w.push(a)}var r=f.requestAnimationFrame||f.webkitRequestAnimationFrame||f.mozRequestAnimationFrame||f.msRequestAnimationFrame;if(b.tf()&&b.Dd()<7)r=i;r=r||function(a){b.Lb(a,h.bb)};function J(){if(q){var d=b.db(),e=c.min(d-D,h.ud),a=j+e*o;D=d;if(a*o>=n*o)a=n;t(a);if(!u&&a*o>=n*o)L(E);else r(J)}}function s(f,h,i){if(!q){q=e;u=i;E=h;f=c.max(f,d);f=c.min(f,g);n=f;o=n<j?-1:1;a.vd();D=b.db();r(J)}}function L(b){if(q){u=q=E=k;a.Cd();b&&b()}}a.Fd=function(a,b,c){s(a?j+a:g,b,c)};a.Id=s;a.ib=L;a.qe=function(a){s(a)};a.U=function(){return j};a.pd=function(){return n};a.Gb=function(){return m};a.W=t;a.pb=function(a){t(j+a)};a.yd=function(){return q};a.Qd=function(a){p=a};a.Ib=P;a.Bd=function(a,b){C(a,0,b)};a.lc=function(a){C(a,1)};a.zd=function(){return d};a.oc=function(){return g};a.Qb=a.vd=a.Cd=a.jc=b.ld;a.kc=b.db();h=b.v({bb:16,ud:50},h);p=h.rc;y=h.le;x=h.he;d=l=B;g=B+F;I=h.Ed||{};G=h.hc||{};H=b.Ic(h.K)};var o=new function(){var h=this;function g(b,a,c){c.push(a);b[a]=b[a]||[];b[a].push(c)}h.Zd=function(d){for(var e=[],a,b=0;b<d.ab;b++)for(a=0;a<d.o;a++)g(e,c.ceil(1e5*c.random())%13,[b,a]);return e}},s=function(n,s,q,u,z){var f=this,v,g,a,y=0,x=u.Yd,r,h=8;function t(a){if(a.i)a.G=a.i;if(a.g)a.C=a.g;b.f(a,function(a){b.lf(a)&&t(a)})}function j(g,f){var a={bb:f,Vb:1,Lb:0,o:1,ab:1,z:0,H:0,a:0,pb:k,Rb:k,Pc:k,Ge:o.Zd,od:{Xd:0,ae:0},K:d.cd,Ed:{},Jb:[],hc:{}};b.v(a,g);t(a);a.K=b.Ic(a.K,d.cd);a.be=c.ceil(a.Vb/a.bb);a.ee=function(c,b){c/=a.o;b/=a.ab;var f=c+"x"+b;if(!a.Jb[f]){a.Jb[f]={hb:c,fb:b};for(var d=0;d<a.o;d++)for(var e=0;e<a.ab;e++)a.Jb[f][e+","+d]={i:e*b,n:d*c+c,p:e*b+b,g:d*c}}return a.Jb[f]};if(a.Cc){a.Cc=j(a.Cc,f);a.Rb=e}return a}function p(B,h,a,w,o,m){var z=this,u,v={},j={},n=[],f,d,s,q=a.od.Xd||0,r=a.od.ae||0,g=a.ee(o,m),p=C(a),D=p.length-1,t=a.Vb+a.Lb*D,x=w+t,l=a.Rb,y;x+=50;function C(a){var b=a.Ge(a);return a.Pc?b.reverse():b}z.sd=x;z.Ob=function(d){d-=w;var e=d<t;if(e||y){y=e;if(!l)d=t-d;var f=c.ceil(d/a.bb);b.f(j,function(a,e){var d=c.max(f,a.Td);d=c.min(d,a.length-1);if(a.Md!=d){if(!a.Md&&!l)b.u(n[e]);else d==a.Nd&&l&&b.P(n[e]);a.Md=d;b.M(n[e],a[d])}})}};h=b.cb(h);b.qb(h,i);if(b.Kb()){var E=!h["no-image"],A=b.ef(h);b.f(A,function(a){(E||a["jssor-slider"])&&b.Ab(a,b.Ab(a),e)})}b.f(p,function(h,i){b.f(h,function(G){var K=G[0],J=G[1],t=K+","+J,n=k,p=k,x=k;if(q&&J%2){if(q&3)n=!n;if(q&12)p=!p;if(q&16)x=!x}if(r&&K%2){if(r&3)n=!n;if(r&12)p=!p;if(r&16)x=!x}a.i=a.i||a.a&4;a.p=a.p||a.a&8;a.g=a.g||a.a&1;a.n=a.n||a.a&2;var E=p?a.p:a.i,B=p?a.i:a.p,D=n?a.n:a.g,C=n?a.g:a.n;a.a=E||B||D||C;s={};d={G:0,C:0,z:1,hb:o,fb:m};f=b.v({},d);u=b.v({},g[t]);if(a.z)d.z=2-a.z;if(a.S){d.S=a.S;f.S=0}var I=a.o*a.ab>1||a.a;if(a.H||a.O){var H=e;if(b.Kb())if(a.o*a.ab>1)H=k;else I=k;if(H){d.H=a.H?a.H-1:1;f.H=1;if(b.Kb()||b.Kd())d.H=c.min(d.H,2);var N=a.O||0;d.O=N*360*(x?-1:1);f.O=0}}if(I){var h=u.ec={};if(a.a){var w=a.Nf||1;if(E&&B){h.i=g.fb/2*w;h.p=-h.i}else if(E)h.p=-g.fb*w;else if(B)h.i=g.fb*w;if(D&&C){h.g=g.hb/2*w;h.n=-h.g}else if(D)h.n=-g.hb*w;else if(C)h.g=g.hb*w}s.a=u;f.a=g[t]}var L=n?1:-1,M=p?1:-1;if(a.x)d.C+=o*a.x*L;if(a.y)d.G+=m*a.y*M;b.f(d,function(a,c){if(b.Xc(a))if(a!=f[c])s[c]=a-f[c]});v[t]=l?f:d;var F=a.be,A=c.round(i*a.Lb/a.bb);j[t]=new Array(A);j[t].Td=A;j[t].Nd=A+F-1;for(var z=0;z<=F;z++){var y=b.Mc(f,s,z/F,a.K,a.hc,a.Ed,{pb:a.pb,Z:o,rb:m});y.S=y.S||1;j[t].push(y)}})});p.reverse();b.f(p,function(a){b.f(a,function(c){var f=c[0],e=c[1],d=f+","+e,a=h;if(e||f)a=b.cb(h);b.M(a,v[d]);b.ob(a,"hidden");b.s(a,"absolute");B.Ye(a);n[d]=a;b.u(a,!l)})})}function w(){var b=this,c=0;l.call(b,0,v);b.Qb=function(d,b){if(b-c>h){c=b;a&&a.Ob(b);g&&g.Ob(b)}};b.Jd=r}f.pe=function(){var a=0,b=u.xb,d=b.length;if(x)a=y++%d;else a=c.floor(c.random()*d);b[a]&&(b[a].jb=a);return b[a]};f.Re=function(w,x,k,l,b){r=b;b=j(b,h);var i=l.qd,e=k.qd;i["no-image"]=!l.Pb;e["no-image"]=!k.Pb;var m=i,o=e,u=b,d=b.Cc||j({},h);if(!b.Rb){m=e;o=i}var t=d.Ib||0;g=new p(n,o,d,c.max(t-d.bb,0),s,q);a=new p(n,m,u,c.max(d.bb-t,0),s,q);g.Ob(0);a.Ob(0);v=c.max(g.sd,a.sd);f.jb=w};f.vb=function(){n.vb();g=i;a=i};f.We=function(){var b=i;if(a)b=new w;return b};if(b.Kb()||b.Kd()||z&&b.rf()<537)h=16;m.call(f);l.call(f,-1e7,1e7)},j=function(p,jc){var o=this;function Ec(){var a=this;l.call(a,-1e8,2e8);a.Xe=function(){var b=a.Gb(),d=c.floor(b),f=v(d),e=b-c.floor(b);return{jb:f,xe:d,wb:e}};a.Qb=function(b,a){var d=c.floor(a);if(d!=a&&a>b)d++;Wb(d,e);o.j(j.ue,v(a),v(b),a,b)}}function Dc(){var a=this;l.call(a,0,0,{rc:r});b.f(C,function(b){F&1&&b.Qd(r);a.lc(b);b.Ib(kb/fc)})}function Cc(){var a=this,b=Vb.lb;l.call(a,-1,2,{K:d.Yb,he:{wb:ec},rc:r},b,{wb:1},{wb:-2});a.Mb=b}function qc(n,m){var b=this,d,f,g,h,c;l.call(b,-1e8,2e8,{ud:100});b.vd=function(){P=e;S=i;o.j(j.ye,v(y.U()),y.U())};b.Cd=function(){P=k;h=k;var a=y.Xe();o.j(j.Ae,v(y.U()),y.U());!a.wb&&Gc(a.xe,s)};b.Qb=function(j,i){var b;if(h)b=c;else{b=f;if(g){var e=i/g;b=a.Be(e)*(f-d)+d}}y.W(b)};b.cc=function(a,e,c,h){d=a;f=e;g=c;y.W(a);b.W(0);b.Id(c,h)};b.Ce=function(a){h=e;c=a;b.Fd(a,i,e)};b.De=function(a){c=a};y=new Ec;y.Bd(n);y.Bd(m)}function sc(){var c=this,a=bc();b.L(a,0);b.R(a,"pointerEvents","none");c.lb=a;c.Ye=function(c){b.E(a,c);b.u(a)};c.vb=function(){b.P(a);b.qc(a)}}function Ac(n,f){var d=this,q,P,x,h,A=[],z,G,Y,J,U,E,N,g,y,p;l.call(d,-w,w+1,{});function H(a){q&&q.Hd();X(n,a,0);E=e;q=new L.N(n,L,b.Cf(b.k(n,"idle"))||oc,!t);q.W(0)}function bb(){q.kc<L.kc&&H()}function R(p,r,n){if(!J){J=e;if(h&&n){var g=n.width,c=n.height,m=g,l=c;if(g&&c&&a.zb){if(a.zb&3&&(!(a.zb&4)||g>K||c>M)){var i=k,q=K/M*c/g;if(a.zb&1)i=q>1;else if(a.zb&2)i=q<1;m=i?g*M/c:K;l=i?M:c*K/g}b.l(h,m);b.m(h,l);b.D(h,(M-l)/2);b.F(h,(K-m)/2)}b.s(h,"absolute");o.j(j.oe,f)}}b.P(r);p&&p(d)}function ab(b,c,e,g){if(g==S&&s==f&&t)if(!Fc){var a=v(b);D.Re(a,f,c,d,e);c.Ee();V.Ib(a-V.zd()-1);V.W(a);B.cc(b,b,0)}}function eb(b){if(b==S&&s==f){if(!g){var a=i;if(D)if(D.jb==f)a=D.We();else D.vb();bb();g=new yc(n,f,a,q);g.nd(p)}!g.yd()&&g.uc()}}function I(e,h,l){if(e==f){if(e!=h)C[h]&&C[h].Uc();else!l&&g&&g.ze();p&&p.Ub();var m=S=b.db();d.Cb(b.I(i,eb,m))}else{var k=c.min(f,e),j=c.max(f,e),o=c.min(j-k,k+r-j),n=w+a.Fe-1;(!U||o<=n)&&d.Cb()}}function fb(){if(s==f&&g){g.ib();p&&p.we();p&&p.ve();g.Lc()}}function hb(){s==f&&g&&g.ib()}function db(a){!Q&&o.j(j.te,f,a)}function T(){p=y.pInstance;g&&g.nd(p)}d.Cb=function(c,a){a=a||x;if(A.length&&!J){b.u(a);if(!Y){Y=e;o.j(j.se,f);b.f(A,function(a){if(!b.A(a,"src")){a.src=b.k(a,"src2")||"";b.gb(a,a["display-origin"])}})}b.Vd(A,h,b.I(i,R,c,a))}else R(c,a)};d.re=function(){var j=f;if(a.Gc<0)j-=r;var e=j+a.Gc*wc;if(F&2)e=v(e);if(!(F&1)&&!ib)e=c.max(0,c.min(e,r-w));if(e!=f){if(D){var g=D.pe(r);if(g){var k=S=b.db(),h=C[v(e)];return h.Cb(b.I(i,ab,e,h,g,k),x)}}cb(e)}else if(t){d.Uc();I(f,f)}};d.Ac=function(){I(f,f,e)};d.Uc=function(){p&&p.we();p&&p.ve();d.Qc();g&&g.Ze();g=i;H()};d.Ee=function(){b.P(n)};d.Qc=function(){b.u(n)};d.He=function(){p&&p.Ub()};function X(a,d,c,i){if(b.A(a,"jssor-slider"))return;if(!E){if(a.tagName=="IMG"){A.push(a);if(!b.A(a,"src")){U=e;a["display-origin"]=b.gb(a);b.P(a)}}var f=b.Pd(a);if(f){var g=new Image;b.k(g,"src2",f);A.push(g)}if(c){b.L(a,(b.L(a)||0)+1);b.mc(a,b.mc(a)||0);b.sc(a,b.sc(a)||0);b.qb(a,{Q:0})}}var j=b.Wb(a);b.f(j,function(f){var j=f.tagName,l=b.k(f,"u");if(l=="player"&&!y){y=f;if(y.pInstance)T();else b.c(y,"dataavailable",T)}if(l=="caption"){if(d){b.Rc(f,b.k(f,"to"));b.pf(f,b.k(f,"bf"));N&&b.k(f,"3d")&&b.of(f,"preserve-3d")}else if(!b.Ld()){var g=b.cb(f,k,e);b.Sb(g,f,a);b.ub(f,a);f=g;d=e}}else if(!E&&!c&&!h){if(j=="A"){if(b.k(f,"u")=="image")h=b.ff(f,"IMG");else h=b.q(f,"image",e);if(h){z=f;b.gb(z,"block");b.M(z,W);G=b.cb(z,e);b.s(z,"relative");b.Ab(G,0);b.R(G,"backgroundColor","#000")}}else if(j=="IMG"&&b.k(f,"u")=="image")h=f;if(h){h.border=0;b.M(h,W)}}X(f,d,c+1,i)});!E&&c&&u.wf(function(){for(var e=1;e<c;e++);b.R(a,"pointerEvents")})}d.jc=function(c,b){var a=w-b;ec(P,a)};d.jb=f;m.call(d);N=b.k(n,"p");b.nf(n,N);b.vf(n,b.k(n,"po"));var O=b.q(n,"thumb",e);if(O){d.Ie=b.cb(O);b.P(O)}b.u(n);x=b.cb(gb);b.L(x,1e3);b.c(n,"click",db);H(e);d.Pb=h;d.Jc=G;d.qd=n;d.Mb=P=n;b.E(P,x);o.Bb(203,I);o.Bb(28,hb);o.Bb(24,fb)}function yc(z,f,p,q){var a=this,m=0,v=0,g,h,d,c,i,u,r,n=C[f];l.call(a,0,0);function w(){b.qc(O);hc&&i&&n.Jc&&b.E(O,n.Jc);b.u(O,!i&&n.Pb)}function x(){a.uc()}function y(b){r=b;a.ib();a.uc()}a.uc=function(){var b=a.Gb();if(!E&&!P&&!r&&s==f){if(!b){if(g&&!i){i=e;a.Lc(e);o.j(j.Ve,f,m,v,g,c)}w()}var k,p=j.Nc;if(b!=c)if(b==d)k=c;else if(b==h)k=d;else if(!b)k=h;else k=a.pd();o.j(p,f,b,m,h,d,c);var l=t&&(!G||H);if(b==c)(d!=c&&!(G&12)||l)&&n.re();else(l||b!=d)&&a.Id(k,x)}};a.ze=function(){d==c&&d==a.Gb()&&a.W(h)};a.Ze=function(){D&&D.jb==f&&D.vb();var b=a.Gb();b<c&&o.j(j.Nc,f,-b-1,m,h,d,c)};a.Lc=function(a){p&&b.ob(lb,a&&p.Jd.Gf?"":"hidden")};a.jc=function(b,a){if(i&&a>=g){i=k;w();n.Qc();D.vb();o.j(j.Ue,f,m,v,g,c)}o.j(j.Se,f,a,m,h,d,c)};a.nd=function(a){if(a&&!u){u=a;a.Bb($JssorPlayer$.ce,y)}};p&&a.lc(p);g=a.oc();a.lc(q);h=g+q.Oc;c=a.oc();d=t?g+q.Hc:c}function Mb(a,c,d){b.F(a,c);b.D(a,d)}function ec(c,b){var a=z>0?z:fb,d=Ab*b*(a&1),e=Bb*b*(a>>1&1);Mb(c,d,e)}function Rb(){rb=P;Kb=B.pd();I=y.U()}function Jb(){Rb();if(E||!H&&G&12){B.ib();o.j(j.Pe)}}function ic(f){if(!E&&(H||!(G&12))&&!B.yd()){var d=y.U(),b=c.ceil(I);if(f&&c.abs(J)>=a.Vc){b=c.ceil(d);b+=jb}if(!(F&1))b=c.min(r-w,c.max(b,0));var e=c.abs(b-d);e=1-c.pow(1-e,5);if(!Q&&rb)B.qe(Kb);else if(d==b){ub.He();ub.Ac()}else B.cc(d,b,e*Yb)}}function Ib(a){!b.k(b.nc(a),"nodrag")&&b.dc(a)}function uc(a){cc(a,1)}function cc(a,c){a=b.td(a);var h=b.nc(a);if(!N&&!b.k(h,"nodrag")&&vc()&&(!c||a.touches.length==1)){E=e;zb=k;S=i;b.c(g,c?"touchmove":"mousemove",Cb);b.db();Q=0;Jb();if(!rb)z=0;if(c){var f=a.touches[0];vb=f.clientX;wb=f.clientY}else{var d=b.Ad(a);vb=d.x;wb=d.y}J=0;hb=0;jb=0;o.j(j.Oe,v(I),I,a)}}function Cb(d){if(E){d=b.td(d);var f;if(d.type!="mousemove"){var l=d.touches[0];f={x:l.clientX,y:l.clientY}}else f=b.Ad(d);if(f){var j=f.x-vb,k=f.y-wb;if(c.floor(I)!=I)z=z||fb&N;if((j||k)&&!z){if(N==3)if(c.abs(k)>c.abs(j))z=2;else z=1;else z=N;if(ob&&z==1&&c.abs(k)-c.abs(j)>3)zb=e}if(z){var a=k,i=Bb;if(z==1){a=j;i=Ab}if(!(F&1)){if(a>0){var g=i*s,h=a-g;if(h>0)a=g+c.sqrt(h)*5}if(a<0){var g=i*(r-w-s),h=-a-g;if(h>0)a=-g-c.sqrt(h)*5}}if(J-hb<-2)jb=0;else if(J-hb>2)jb=-1;hb=J;J=a;tb=I-J/i/(Z||1);if(J&&z&&!zb){b.dc(d);if(!P)B.Ce(tb);else B.De(tb)}}}}}function bb(){tc();if(E){E=k;b.db();b.T(g,"mousemove",Cb);b.T(g,"touchmove",Cb);Q=J;Q&&t&8&&(t=0);B.ib();var a=y.U();o.j(j.Ne,v(a),a,v(I),I);G&12&&Rb();ic(e)}}function nc(c){if(Q){b.jf(c);var a=b.nc(c);while(a&&x!==a){a.tagName=="A"&&b.dc(c);try{a=a.parentNode}catch(d){break}}}else t&4&&(t=0)}function Lb(a){C[s];s=v(a);ub=C[s];Wb(a);return s}function Gc(b,c){z=0;Lb(b);var a=v(b);if(t&2&&Xb>0&&a==r-1||Xb<0&&!a)t=0;o.j(j.Le,a,c)}function Wb(a,c){xb=a;b.f(T,function(b){b.tc(v(a),a,c)})}function vc(){var b=j.kd||0,a=Y;if(ob)a&1&&(a&=1);j.kd|=a;return N=a&~b}function tc(){if(N){j.kd&=~Y;N=0}}function bc(){var a=b.sb();b.M(a,W);b.s(a,"absolute");return a}function v(a){return(a%r+r)%r}function qb(b,d){t&8&&(t=0);if(d)if(!F){b=c.min(c.max(b+xb,0),r-w);d=k}else if(F&2){b=v(b+xb);d=k}cb(b,a.vc,d)}function yb(){b.f(T,function(a){a.wc(a.Nb.Ff<=H)})}function lc(){if(!H){H=1;yb();if(!E){G&12&&ic();G&3&&C[s]&&C[s].Ac()}}}function kc(){if(H){H=0;yb();E||!(G&12)||Jb()}}function mc(){W={hb:K,fb:M,i:0,g:0};b.f(U,function(a){b.M(a,W);b.s(a,"absolute");b.ob(a,"hidden");b.P(a)});b.M(gb,W)}function cb(g,f,l){if(Tb&&(!E&&(H||!(G&12))||a.jd)){P=e;E=k;B.ib();if(f==h)f=Yb;var d=Db.Gb(),b=g;if(l){b=d+g;if(g>0)b=c.ceil(b);else b=c.floor(b)}if(F&2)b=v(b);if(!(F&1))b=c.max(0,c.min(b,r-w));var j=(b-d)%r;b=d+j;var i=d==b?0:f*c.abs(j);i=c.min(i,f*w*1.5);B.cc(d,b,i||1)}}o.Ud=cb;o.Fd=function(){o.yb(t||1)};o.yb=function(a){if(a==h)return a;if(a!=t){t=a;t&&C[s]&&C[s].Ac()}};o.Rd=function(){return Q};function X(){return b.l(A||p)}function mb(){return b.m(A||p)}o.Z=X;o.rb=mb;function Fb(c,d){if(c==h)return b.l(p);if(!A){var a=b.sb(g);b.Wc(a,b.Wc(p));b.Zb(a,b.Zb(p));b.gb(a,"block");b.s(a,"relative");b.D(a,0);b.F(a,0);b.ob(a,"visible");A=b.sb(g);b.s(A,"absolute");b.D(A,0);b.F(A,0);b.l(A,b.l(p));b.m(A,b.m(p));b.Rc(A,"0 0");b.E(A,a);var i=b.Wb(p);b.E(p,A);b.R(p,"backgroundImage","");b.f(i,function(c){b.E(b.k(c,"noscale")?p:a,c);b.k(c,"autocenter")&&Nb.push(c)})}Z=c/(d?b.m:b.l)(A);b.mf(A,Z);var f=d?Z*X():c,e=d?c:Z*mb();b.l(p,f);b.m(p,e);b.f(Nb,function(a){var c=b.bf(b.k(a,"autocenter"));b.zf(a,c)})}o.Od=Fb;o.id=function(a){var d=c.ceil(v(kb/fc)),b=v(a-s+d);if(b>w){if(a-s>r/2)a-=r;else if(a-s<=-r/2)a+=r}else a=s+b-d;return a};m.call(o);o.lb=p=b.kb(p);var a=b.v({zb:0,Fe:1,xc:1,yc:0,yb:0,Tb:1,Db:e,jd:e,Gc:1,hd:3e3,gd:1,vc:500,Be:d.gf,Vc:20,fd:0,o:1,Bc:0,de:1,zc:1,ed:1},jc);a.Db=a.Db&&b.sf();if(a.me!=h)a.hd=a.me;if(a.ke!=h)a.Bc=a.ke;var fb=a.zc&3,wc=(a.zc&4)/-4||1,nb=a.Sd,L=b.v({N:q,Db:a.Db},a.Jf);L.xb=L.xb||L.Hf;var Gb=a.je,ab=a.ie,eb=a.ge,R=!a.de,A,x=b.q(p,"slides",R),gb=b.q(p,"loading",R)||b.sb(g),Pb=b.q(p,"navigator",R),gc=b.q(p,"arrowleft",R),dc=b.q(p,"arrowright",R),Ob=b.q(p,"thumbnavigator",R),rc=b.l(x),pc=b.m(x),W,U=[],xc=b.Wb(x);b.f(xc,function(a){a.tagName=="DIV"&&!b.k(a,"u")&&U.push(a);b.L(a,(b.L(a)||0)+1)});var s=-1,xb,ub,r=U.length,K=a.fe||rc,M=a.ne||pc,Zb=a.fd,Ab=K+Zb,Bb=M+Zb,fc=fb&1?Ab:Bb,w=c.min(a.o,r),lb,z,N,zb,T=[],Sb,Ub,Qb,hc,Fc,t,Xb=a.Gc,G=a.gd,oc=a.hd,Yb=a.vc,sb,ib,kb,Tb=w<r,F=Tb?a.Tb:0,Y,Q,H=1,P,E,S,vb=0,wb=0,J,hb,jb,Db,y,V,B,Vb=new sc,Z,Nb=[];if(r){if(a.Db)Mb=function(a,c,d){b.qb(a,{mb:c,nb:d})};t=a.yb&63;o.Nb=jc;mc();b.A(p,"jssor-slider",e);b.L(x,b.L(x)||0);b.s(x,"absolute");lb=b.cb(x,e);b.Sb(lb,x);if(nb){hc=nb.If;sb=nb.N;ib=w==1&&r>1&&sb&&(!b.Ld()||b.Dd()>=8)}kb=ib||w>=r||!(F&1)?0:a.Bc;Y=(w>1||kb?fb:-1)&a.ed;var Hb=x,C=[],D,O,Eb=b.uf(),ob=Eb.xf,I,rb,Kb,tb;Eb.xd&&b.R(Hb,Eb.xd,([i,"pan-y","pan-x","none"])[Y]||"");V=new Cc;if(ib)D=new sb(Vb,K,M,nb,ob);b.E(lb,V.Mb);b.ob(x,"hidden");O=bc();b.R(O,"backgroundColor","#000");b.Ab(O,0);b.Sb(O,Hb.firstChild,Hb);for(var db=0;db<U.length;db++){var zc=U[db],Bc=new Ac(zc,db);C.push(Bc)}b.P(gb);Db=new Dc;B=new qc(Db,V);b.c(x,"click",nc,e);b.c(p,"mouseout",b.gc(lc,p));b.c(p,"mouseover",b.gc(kc,p));if(Y){b.c(x,"mousedown",cc);b.c(x,"touchstart",uc);b.c(x,"dragstart",Ib);b.c(x,"selectstart",Ib);b.c(g,"mouseup",bb);b.c(g,"touchend",bb);b.c(g,"touchcancel",bb);b.c(f,"blur",bb)}G&=ob?10:5;if(Pb&&Gb){Sb=new Gb.N(Pb,Gb,X(),mb());T.push(Sb)}if(ab&&gc&&dc){ab.Tb=F;ab.o=w;Ub=new ab.N(gc,dc,ab,X(),mb());T.push(Ub)}if(Ob&&eb){eb.yc=a.yc;Qb=new eb.N(Ob,eb);T.push(Qb)}b.f(T,function(a){a.Ec(r,C,gb);a.Bb(n.Hb,qb)});b.R(p,"visibility","visible");Fb(X());yb();a.xc&&b.c(g,"keydown",function(b){if(b.keyCode==37)qb(-a.xc,e);else b.keyCode==39&&qb(a.xc,e)});var pb=a.yc;if(!(F&1))pb=c.max(0,c.min(pb,r-w));B.cc(pb,pb,0)}};j.te=21;j.Oe=22;j.Ne=23;j.ye=24;j.Ae=25;j.se=26;j.oe=27;j.Pe=28;j.ue=202;j.Le=203;j.Ve=206;j.Ue=207;j.Se=208;j.Nc=209;var n={Hb:1},r=function(d,C){var f=this;m.call(f);d=b.kb(d);var s,A,z,r,l=0,a,o,j,w,x,h,g,q,p,B=[],y=[];function v(a){a!=-1&&y[a].bd(a==l)}function t(a){f.j(n.Hb,a*o)}f.lb=d;f.tc=function(a){if(a!=r){var d=l,b=c.floor(a/o);l=b;r=a;v(d);v(b)}};f.wc=function(a){b.u(d,a)};var u;f.Ec=function(D){if(!u){s=c.ceil(D/o);l=0;var n=q+w,r=p+x,m=c.ceil(s/j)-1;A=q+n*(!h?m:j-1);z=p+r*(h?m:j-1);b.l(d,A);b.m(d,z);for(var f=0;f<s;f++){var C=b.cf();b.hf(C,f+1);var k=b.ad(g,"numbertemplate",C,e);b.s(k,"absolute");var v=f%(m+1);b.F(k,!h?n*v:f%j*n);b.D(k,h?r*v:c.floor(f/(m+1))*r);b.E(d,k);B[f]=k;a.Eb&1&&b.c(k,"click",b.I(i,t,f));a.Eb&2&&b.c(k,"mouseover",b.gc(b.I(i,t,f),k));y[f]=b.Xb(k)}u=e}};f.Nb=a=b.v({Fc:10,Dc:10,Fb:1,Eb:1},C);g=b.q(d,"prototype");q=b.l(g);p=b.m(g);b.ub(g,d);o=a.Zc||1;j=a.ab||1;w=a.Fc;x=a.Dc;h=a.Fb-1;a.fc==k&&b.A(d,"noscale",e);a.eb&&b.A(d,"autocenter",a.eb)},t=function(a,g,h){var c=this;m.call(c);var r,d,f,j;b.l(a);b.m(a);var p,o;function l(a){c.j(n.Hb,a,e)}function t(c){b.u(a,c);b.u(g,c)}function s(){p.Ub(h.Tb||d>0);o.Ub(h.Tb||d<r-h.o)}c.tc=function(b,a,c){if(c)d=a;else{d=b;s()}};c.wc=t;var q;c.Ec=function(c){r=c;d=0;if(!q){b.c(a,"click",b.I(i,l,-j));b.c(g,"click",b.I(i,l,j));p=b.Xb(a);o=b.Xb(g);q=e}};c.Nb=f=b.v({Zc:1},h);j=f.Zc;if(f.fc==k){b.A(a,"noscale",e);b.A(g,"noscale",e)}if(f.eb){b.A(a,"autocenter",f.eb);b.A(g,"autocenter",f.eb)}},p=function(g,B){var h=this,z,p,a,v=[],x,w,d,q,r,u,t,o,s,f,l;m.call(h);g=b.kb(g);function A(o,f){var g=this,c,m,k;function q(){m.bd(p==f)}function j(e){if(e||!s.Rd()){var a=d-f%d,b=s.id((f+a)/d-1),c=b*d+d-a;h.j(n.Hb,c)}}g.jb=f;g.Yc=q;k=o.Ie||o.Pb||b.sb();g.Mb=c=b.ad(l,"thumbnailtemplate",k,e);m=b.Xb(c);a.Eb&1&&b.c(c,"click",b.I(i,j,0));a.Eb&2&&b.c(c,"mouseover",b.gc(b.I(i,j,1),c))}h.tc=function(b,e,f){var a=p;p=b;a!=-1&&v[a].Yc();v[b].Yc();!f&&s.Ud(s.id(c.floor(e/d)))};h.wc=function(a){b.u(g,a)};var y;h.Ec=function(D,C){if(!y){z=D;c.ceil(z/d);p=-1;o=c.min(o,C.length);var h=a.Fb&1,m=u+(u+q)*(d-1)*(1-h),l=t+(t+r)*(d-1)*h,B=m+(m+q)*(o-1)*h,n=l+(l+r)*(o-1)*(1-h);b.s(f,"absolute");b.ob(f,"hidden");a.eb&1&&b.F(f,(x-B)/2);a.eb&2&&b.D(f,(w-n)/2);b.l(f,B);b.m(f,n);var i=[];b.f(C,function(l,g){var j=new A(l,g),e=j.Mb,a=c.floor(g/d),k=g%d;b.F(e,(u+q)*k*(1-h));b.D(e,(t+r)*k*h);if(!i[a]){i[a]=b.sb();b.E(f,i[a])}b.E(i[a],e);v.push(j)});var E=b.v({yb:0,jd:k,fe:m,ne:l,fd:q*h+r*(1-h),Vc:12,vc:200,gd:1,zc:a.Fb,ed:a.Wd||a.Kf?0:a.Fb},a);s=new j(g,E);y=e}};h.Nb=a=b.v({Fc:0,Dc:0,o:1,Fb:1,eb:3,Eb:1},B);x=b.l(g);w=b.m(g);f=b.q(g,"slides",e);l=b.q(f,"prototype");u=b.l(l);t=b.m(l);b.ub(l,f);d=a.ab||1;q=a.Fc;r=a.Dc;o=a.o;a.fc==k&&b.A(g,"noscale",e)};function q(e,d,c){var a=this;l.call(a,0,c);a.Hd=b.ld;a.Oc=0;a.Hc=c}jssor_1_slider_init=function(){var h=[{Vb:1200,x:-.3,hc:{g:[.3,.7]},K:{g:d.dd,z:d.Yb},z:2},{Vb:1200,x:.3,Rb:e,K:{g:d.dd,z:d.Yb},z:2}],i={yb:1,Sd:{N:s,xb:h,Yd:1},ie:{N:t},je:{N:r},ge:{N:p,o:1,Bc:0,Wd:e}},g=new j("jssor_1",i);function a(){var b=g.lb.parentNode.clientWidth;if(b){b=c.min(b,600);g.Od(b)}else f.setTimeout(a,30)}a();b.c(f,"load",a);b.c(f,"resize",a);b.c(f,"orientationchange",a)}})(window,document,Math,null,true,false)
</script>
</head>
<body
	style="padding: 0px; margin: 0px; background-color: #fff; font-family: 'Open Sans', sans-serif, arial, helvetica, verdana">
	>


	<!-- #region Jssor Slider Begin -->
	<!-- Generator: Jssor Slider Maker -->
	<!-- Source: http://www.jssor.com -->
	<!-- This is deep minimized code which works independently. -->

	<h2 style="margin: auto;">
		<b>New Images</b>
	</h2>
	
		<div class="w3-row-padding">
	<c:forEach items="${newlist }" var="dto">
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="${pageContext.request.contextPath }/img_item/storage/${dto.img_photo }"
					style="width: 400px; height: 400px" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<h3>${dto.id }</h3>
					<p>View : ${dto.img_viewcnt }</p>
					<p>Latest Posts : ${dto.img_date }</p>
				</div>
			</div>
	</c:forEach>
		</div>


	<h2 style="margin: auto;">

          <h2></i>Best</h2>
	</h2>
	<div id="jssor_1"
		style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden; visibility: hidden;">
		<!-- Loading Screen -->
		<div data-u="loading"
			style="position: absolute; top: 0px; left: 0px; background-color: rgba(0, 0, 0, 0.7);">
			<div
				style="filter: alpha(opacity = 70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
			<div
				style="position: absolute; display: block; background: url('img/loading.gif') no-repeat center center; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
		</div>
		<div data-u="slides"
			style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">

			<c:forEach items="${list}" var="dto">
				<div>
					<img data-u="image"
						src="${pageContext.request.contextPath }/img_item/storage/${dto.img_photo }" />
					<div data-u="thumb">Photograph : ${dto.id } / Views :
						${dto.img_viewcnt }</div>
				</div>
			</c:forEach>

		</div>
		<!-- Thumbnail Navigator -->
		<div data-u="thumbnavigator" class="jssort09-600-45"
			style="position: absolute; bottom: 0px; left: 0px; width: 600px; height: 45px;">
			<div
				style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: #000; filter: alpha(opacity = 40.0); opacity: 0.4;"></div>
			<!-- Thumbnail Item Skin Begin -->
			<div data-u="slides" style="cursor: default;">
				<div data-u="prototype" class="p">
					<div data-u="thumbnailtemplate" class="t"></div>
				</div>
			</div>
			<!-- Thumbnail Item Skin End -->
		</div>
		<!-- Bullet Navigator -->
		<div data-u="navigator" class="jssorb01"
			style="bottom: 16px; right: 16px;">
			<div data-u="prototype" style="width: 12px; height: 12px;"></div>
		</div>
		<!-- Arrow Navigator -->
		<span data-u="arrowleft" class="jssora05l"
			style="top: 0px; left: 8px; width: 40px; height: 40px;"
			data-autocenter="2"></span> <span data-u="arrowright"
			class="jssora05r"
			style="top: 0px; right: 8px; width: 40px; height: 40px;"
			data-autocenter="2"></span>
	</div>
	<script type="text/javascript">jssor_1_slider_init();</script>
	<!-- #endregion Jssor Slider End -->


</body>
</html>

