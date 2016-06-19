var FKAffWidget = {},
    fkAffiliateWidgets = document.querySelectorAll("[data-class=affiliateAdsByFlipkart]");
! function() {
    FKAffWidget.init = function() {
        for (var t = 0; t < fkAffiliateWidgets.length; t++) {
            var e = fkAffiliateWidgets[t],
                i = e.getAttribute("data-WRID");
            if (null == e.getAttribute("isLoaded")) {
                var r = !1,
                    d = "",
                    a = "";
                if (this.isResponsive(e)) {
                    var f = this.getParentWidthOfWidgetContainer(e);
                    a = f.width + "px", d = e.getAttribute("height") + "px", r = !0
                } else a = e.getAttribute("width") + "px", d = e.getAttribute("height") + "px";
                e.removeAttribute("width"), e.removeAttribute("height"), e.style.width = a, e.style.height = d, this.createFKWidgetIframe(e, i, a, d, r)
            }
        }
    }, FKAffWidget.loadMoreScript = function(t, e) {
        if (!this.isScripAlreadyLoaded(t)) {
            var i = document.createElement("script");
            i.onload = e, i.src = location.protocol + "//affiliate-static.flixcart.com/affiliate/widgets/" + t, document.getElementsByTagName("head")[0].appendChild(i), window[t] = !0
        }
    }, FKAffWidget.isScripAlreadyLoaded = function(t) {
        return 1 == window[t] ? !0 : !1
    }, FKAffWidget.createFKWidgetIframe = function(t, e, i, r, d) {
        var a = document.createElement("IFRAME"),
            f = {};
        1 == d && (f = {
            width: i.replace("px", "")
        }), a.setAttribute("src", location.protocol + "//affiliate.flipkart.com/widget/displayWidget?wrid=" + e + "&environment=" + JSON.stringify(f)), a.style.width = i.replace(/[^\d.]/g, "").toString() + "px", a.style.height = r.replace(/[^\d.]/g, "").toString() + "px", a.style.borderWidth = 0, t.appendChild(a), t.setAttribute("isLoaded", "y")
    }, FKAffWidget.isMobile = function() {
        return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ? !0 : !1
    }, FKAffWidget.isResponsive = function(t) {
        return "yes" === t.getAttribute("data-responsive") ? !0 : !1
    }, FKAffWidget.getParentWidthOfWidgetContainer = function(t) {
        var e = t.parentNode,
            i = {
                width: e.offsetWidth
            };
        return i
    }, FKAffWidget.getLoadedWidgets = function() {
        for (var t = {}, e = 0; e < fkAffiliateWidgets.length; e++) {
            var i = fkAffiliateWidgets[e],
                r = i.getAttribute("data-widgetType");
            if (r in t) {
                var d = t[r];
                t[r] = parseInt(d) + 1
            } else t[r] = 1
        }
        return t
    }, FKAffWidget.init(), FKAffWidget.loadMoreScript("FKFECollector.js", function() {})
}();