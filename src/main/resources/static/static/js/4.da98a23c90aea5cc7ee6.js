webpackJsonp([4],{FrK4:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=i("ktvg"),s={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"myHotelInfo",attrs:{"element-loading-text":"en"==t.primaryLangID?"Loading":"酒店数据加载中"}},[i("el-dialog",{attrs:{title:""+t.$t("m.PriceOfCalendar"),visible:t.dialogTableVisible},on:{"update:visible":function(e){t.dialogTableVisible=e}}},[i("el-calendar",{model:{value:t.priceTime,callback:function(e){t.priceTime=e},expression:"priceTime"}})],1),t._v(" "),i("div",{staticClass:"myHotelDetail-mainContentDiv"},[i("div",[i("div",{staticClass:"hotelImagesDiv"},t._l(t.pictures,function(e,n){return i("el-image",{key:n,attrs:{src:e.uRL,"preview-src-list":t.srcList},on:{error:function(e){return t.hideErrorImage(n)}}})}),1),t._v(" "),i("div",{staticClass:"hotelInfoDiv"},[i("ul",{staticClass:"infoUl"},[i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.hotelChineseName"))+"：")]),t._v("\n            "+t._s(t.hotel.hotelName)+"\n          ")]),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.hotelEnglishName"))+"：")]),t._v("\n            "+t._s(t.hotel.hotelEName?t.hotel.hotelEName:"-")+"\n          ")]),t._v(" "),t.hoteltype?i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.startingPrice"))+"：")]),t._v("\n            "+t._s(t.formatterStartingPrice(t.minPriceInfo))+"\n            "),i("span",{staticClass:"dateSpan",on:{click:t.openDate}},[t._v(t._s(t.$t("m.PriceOfCalendar")))])]):t._e(),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.hotelBrand"))+"：")]),t._v("\n            "+t._s(t.hotel.brand&&t.hotel.brand.name?t.hotel.brand.name:"-")+"\n          ")]),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.starRating"))+"：")]),t._v(" "),i("el-rate",{attrs:{disabled:"","show-score":"","text-color":"#ff9900","score-template":"{value}"},model:{value:t.starRating,callback:function(e){t.starRating=e},expression:"starRating"}})],1),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.isOfficialRating"))+"：")]),t._v("\n            "+t._s("en"==t.primaryLangID?t.hotel.isOfficialRating:t.hotel.isOfficialRating?"是":"否")+"\n          ")]),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.ctripListedGrade"))+"：")]),t._v("\n            "+t._s(t.formatterGrade(t.hotel.rStar))+"\n          ")]),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.openYear"))+"：")]),t._v("\n            "+t._s(t.hotel.openYear?t.hotel.openYear.slice(0,10):"-")+"\n          ")]),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.refurbishedTime"))+"：")]),t._v("\n            "+t._s(t.hotel.renovationYear?t.hotel.renovationYear.slice(0,10):"-")+"\n          ")]),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.phone"))+"：")]),t._v("\n            "+t._s(t.contactInfo?t.contactInfo.telephone:"-")+"\n          ")]),t._v(" "),i("li",{staticClass:"infoLi overnone"},[i("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.address"))+"：")]),t._v("\n            "+t._s(t.formatterAddress(t.hotel.address))+"\n          ")])]),t._v(" "),i("div",{staticClass:"statementDiv"},[t._l(t.descriptions.description,function(e,n){return t.descriptions&&t.descriptions.description&&t.descriptions.description.length?i("div",{key:n,staticClass:"descriptions"},[i("span",{staticClass:"descriptionsSpan"},[t._v("\n                "+t._s(1==e.category?t.$t("m.features"):t.$t("m.brief"))+"：\n              ")]),t._v(" "),i("div",{staticClass:"descriptionsDiv"},[i("span",{attrs:{id:"descriptions"+e.category}},[t._v("\n                "+t._s(t.formatterDescription(e))+"\n              ")])])]):t._e()}),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.importantNotices.importantNotice&&t.importantNotices.importantNotice.length,expression:"importantNotices.importantNotice && importantNotices.importantNotice.length"}],staticClass:"descriptions",staticStyle:{margin:"30px 0!important"}},[i("span",{staticClass:"descriptionsSpan",staticStyle:{color:"red!important"}},[t._v("\n              "+t._s(t.$t("m.notice"))+"：\n            ")]),t._v(" "),i("span",{staticClass:"descriptionsDiv"},[i("ul",{staticClass:"importantNoticeUl"},[i("span",{staticClass:"rightContent"},t._l(t.importantNotices.importantNotice,function(e,n){return i("li",{directives:[{name:"show",rawName:"v-show",value:t.getImportantNotice(e),expression:"getImportantNotice(importantNotice)"}],key:n,staticClass:"importantNoticeLi"},[i("span",{attrs:{id:"importantNoticeSpan"+n}},[t._v(t._s(t.setImportantNotice(n,e.text)))])])}),0)])])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.facilities.length,expression:"facilities.length"}],staticClass:"descriptions",staticStyle:{margin:"30px 0!important"}},[i("span",{staticClass:"descriptionsSpan"},[t._v("\n              "+t._s(t.$t("m.facilities"))+"：\n            ")]),t._v(" "),i("div",{staticClass:"descriptionsDiv"},[i("span",t._l(t.facilities,function(e,n){return i("ul",{key:n,staticClass:"facilitieUl"},[i("span",{staticClass:"leftTitle overnone"},[t._v("\n                    "+t._s(e.categoryName)+"：\n                  ")]),t._v(" "),i("span",{staticClass:"rightContent"},t._l(e.facilityItem,function(e,n){return i("li",{directives:[{name:"show",rawName:"v-show",value:0!=e.status,expression:"facilityItem.status != 0"}],key:n,staticClass:"facilitieLi"},[i("span",[t._v(t._s(e.name)+t._s(1==e.status?"":"（部分有）"))])])}),0)])}),0)])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.policies.policy,expression:"policies.policy"}],staticClass:"descriptions",staticStyle:{margin:"30px 0!important"}},[i("span",{staticClass:"descriptionsSpan"},[t._v("\n              "+t._s(t.$t("m.policies"))+"：\n            ")]),t._v(" "),i("div",{staticClass:"descriptionsDiv"},[i("span",t._l(t.policies.policy,function(e,n){return i("ul",{directives:[{name:"show",rawName:"v-show",value:e.text,expression:"policie.text"}],key:n,staticClass:"facilitieUl"},[i("span",{staticClass:"leftTitle"},[t._v("\n                    "+t._s(e.code)+"：\n                  ")]),t._v(" "),Array.isArray(e.text)?i("span",{staticClass:"rightContent"},t._l(e.text,function(e,n){return i("li",{key:n,staticClass:"policyLi",staticStyle:{"list-style-type":"square!important"}},[i("span",{attrs:{id:"policy"+n}},[t._v(t._s(t.formatterPolicie(e,"policy"+n)))])])}),0):i("span",{staticClass:"rightContent"},[i("li",{staticClass:"facilitieLi"},[i("span",{attrs:{id:"policie"+n}},[t._v(t._s(t.formatterPolicie(e.text,"policie"+n)))])])])])}),0)])])],2)])])])],1)},staticRenderFns:[]};var a=function(t){i("OgkH")},o=i("VU/8")(n.a,s,!1,a,null,null);e.default=o.exports},OgkH:function(t,e){},ktvg:function(t,e,i){"use strict";(function(t){var n=i("Xxa5"),s=i.n(n),a=i("NC6I"),o=i.n(a),r=i("D2Ra"),c=i("NYxO"),l=i("kw8N"),p=(i.n(l),Object.assign||function(t){for(var e=1;e<arguments.length;e++){var i=arguments[e];for(var n in i)Object.prototype.hasOwnProperty.call(i,n)&&(t[n]=i[n])}return t});function f(t){return function(){var e=t.apply(this,arguments);return new Promise(function(t,i){return function n(s,a){try{var o=e[s](a),r=o.value}catch(t){return void i(t)}if(!o.done)return Promise.resolve(r).then(function(t){n("next",t)},function(t){n("throw",t)});t(r)}("next")})}}e.a={name:"",data:function(){return{hotelID:"",extendedNode:["HotelStaticInfo.GeoInfo","HotelStaticInfo.NearbyPOIs","HotelStaticInfo.TransportationInfos","HotelStaticInfo.Brand","HotelStaticInfo.Policies","HotelStaticInfo.ImportantNotices","HotelStaticInfo.Facilities","HotelStaticInfo.Descriptions","HotelStaticInfo.Themes","HotelStaticInfo.ContactInfo","HotelStaticInfo.SupplierInfo","HotelStaticInfo.Pictures"],hotel:[],pictures:[],srcList:[],contactInfo:"",starRating:0,descriptions:{},facilities:"",importantNotices:{},policies:"",dialogTableVisible:!1,priceTime:"",minPriceInfo:"",hoteltype:0,loading:!1}},methods:p({},Object(c.b)(["choiceMenuId","setDetailType"]),{returnHeaders:function(t){var e=(new Date).getTime()+"",i={timestamp:e,interfacekey:"15456a8b-f9b3-4e39-83cf-7186b9cb6336",requesttype:t,signature:o()(e+109+o()("15456a8b-f9b3-4e39-83cf-7186b9cb6336").toUpperCase()+104+t).toUpperCase(),"Content-Type":"application/json;charset=UTF-8"};return this.hoteltype?i.hoteltype="3":i.masterhotelmode="T",i},reqHotelsStatic:function(){var t=this;return f(s.a.mark(function e(){var i,n,a,o,c,l,p,f,m,u,d;return s.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return i=t.extendedNode,n=t.primaryLangID,a=t.hotelID,o=t.returnHeaders("GET_HOTEL_STATICINFO"),c={hotelID:a},l={primaryLangID:n,extendedNodes:{extendedNode:i}},t.loading=!0,e.next=8,Object(r.j)({searchCandidate:c,settings:l},o);case 8:p=e.sent,t.loading=!1,(f=p.ResponseStatus)&&0==f.Errors.length?(t.hotel=p.hotelStaticInfo,console.log(t.hotel),t.hotel.hasOwnProperty("address")&&(t.contactInfo=t.hotel.contactInfo,(m=t.hotel.facilities)&&m.facility&&m.facility.length>0?t.facilities=t.getFacilities(m.facility):t.facilities=[],t.importantNotices=t.hotel.importantNotices,u=t.getChild(t.hotel.childInfo),t.policies=t.hotel.policies,t.policies&&t.policies.policy.map(function(t){"Child"==t.code&&(t.text=u)}),t.descriptions=t.hotel.descriptions||{},t.hotel.starRating?t.starRating=t.hotel.starRating:t.starRating=0,t.hotel.pictures&&(t.srcList=[],d=(d=(d=t.hotel.pictures).picture).filter(function(t){return"HOTEL"==t.source}),t.pictures=d.slice(0,10),t.pictures.map(function(e){t.srcList.push(e.uRL)})),""==t.minPriceInfo&&1==t.hoteltype&&t.reqHotelPrice())):t.show=!1;case 12:case"end":return e.stop()}},e,t)}))()},reqHotelPrice:function(){var t=this;return f(s.a.mark(function e(){var i,n,a,o,c,l,p,f,m;return s.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return i=t.priceTime,n=t.hotelID,a=t.dateToStr(i),o=t.dateToStr(i),c=t.returnHeaders("GET_HOTEL_MINPRICE"),(l=[]).push(n),p={start:o,end:a},e.next=9,Object(r.g)({dateTimeRage:p,hotelIds:l},c);case 9:f=e.sent,(m=f.ResponseStatus)&&0==m.Errors.length?(t.minPriceInfo=f.hotelMinPrices,t.minPriceInfo.length>0?t.minPriceInfo=t.minPriceInfo[0].minPriceInfo:t.minPriceInfo=[]):t.minPriceInfo=[];case 12:case"end":return e.stop()}},e,t)}))()},getFacilities:function(t){var e=[];return t.map(function(t){var i=!1;if(e.map(function(e){e.categoryName==t.categoryName&&(i=!0,t.facilityItem.map(function(t){e.facilityItem.push(t)}))}),!i){var n={categoryName:t.categoryName,facilityItem:[]};t.facilityItem.map(function(t){n.facilityItem.push(t)}),e.push(n)}}),e},getImportantNotice:function(t){if(t.start){var e=t.start.slice(0,10),i=t.end.slice(0,10);e=new Date(e.split("-").join("/")),i=new Date(i.split("-").join("/"));var n=new Date;if(n.getTime()>=e.getTime()&&n.getTime()<=i.getTime())return!0}else if(t.text)return!0;return!1},setImportantNotice:function(e,i){setTimeout(function(){t("#importantNoticeSpan"+e).html(i)},150)},formatterDescription:function(e){if(e){var i=1*e.category,n=e.text;n||(n="-"),setTimeout(function(){t("#descriptions"+i).html(n)},200)}},formatterPolicie:function(e,i){setTimeout(function(){t("#"+i).html(e)},300)},getChild:function(t){var e=[],i=0,n=0,s=0,a="",o="",r="",c="";for(var l in t){if("childContent"==l&&t[l]&&(a=t[l]),"allowAccomChd"==l&&(o=t[l]?"允许携带儿童":"不允许携带儿童"),"allowUsingExgBed"==l&&t.allowAccomChd)if(t[l])r="儿童可以使用现有床位";else r="儿童不可以使用现有床位";"limitOfChdOnExgBed"==l&&t.allowUsingExgBed&&t.allowAccomChd&&(r="可使用现有床位最多"+t[l]+"名儿童"),"rangeType"==l&&(i=t[l]),"rangeFromOnExgBed"==l&&(s=t[l]),"rangeToOnExgBed"==l&&(n=t[l])}if(t.allowUsingExgBed&&t.allowAccomChd){var p="";1==i?p=0!=n&&0!=s&&-1!=n&&-1!=s?"现有床位适合"+s+"岁以上"+n+"岁以下（不包含"+n+"岁）儿童":0==n&&0==s?"现有床位适合1岁以下的儿童":s<=0&&n>0?"现有床位适合"+n+"岁以下（不包含"+n+"岁）儿童":s>0&&n<0?"现有床位适合"+s+"岁以上儿童":"":2==i&&(p=s>0?n>0?"现有床位适合身高在"+s+"cm以上"+n+"cm以下（不包含"+n+"cm）儿童":"现有床位适合身高在"+s+"cm以上的儿童":n>0?"现有床位适合身高在"+n+"cm以下的儿童":""),c=p}return o&&e.push(o),r&&e.push(r),c&&e.push(c),a&&e.push(a),e},formatterAddress:function(t){if(t){var e=t.city,i=t.area,n=t.addressLine;return(e?e.name:"")+(i?i.name:"")+(n||"")}return"-"},formatterGrade:function(t){return t>=4?4==t?4+this.primaryLangID=="en"?"(Silver medal)":"（银牌）":5==t?5+this.primaryLangID=="en"?"(Gold medal)":"（金牌）":t+this.primaryLangID=="en"?"(Special brand)":"（特牌）":t},formatterStartingPrice:function(t){if(t){var e=t[0];return e?-1==e.amount?"-":e.currency+" "+e.amount:"-"}return"-"},dateToStr:function(t){var e=t.getFullYear(),i=t.getMonth()+1,n=t.getDate();return i<10&&(i="0"+i),n<10&&(n="0"+n),e+"-"+i+"-"+n},hideErrorImage:function(t){var e=this.srcList;e[t]="",e=e.filter(function(t){return""!=t}),this.srcList=e},openDate:function(){var t=this;this.dialogTableVisible=!0,this.$nextTick(function(){document.querySelector("tbody").addEventListener("click",function(){t.dialogTableVisible=!1,t.reqHotelPrice()})})},message:function(t,e,i){this.$message({message:t,duration:i,type:e})}}),watch:{primaryLangID:function(t,e){this.rooms=[],this.hotel=[],this.reqHotelsStatic()}},computed:p({},Object(c.c)(["primaryLangID"])),created:function(){this.$route.query.hotelID&&this.$route.query.hoteltype?(this.hotelID=JSON.parse(this.$route.query.hotelID),this.hoteltype=JSON.parse(this.$route.query.hoteltype),this.priceTime=new Date,this.reqHotelsStatic()):this.$router.go(-1)},mounted:function(){this.choiceMenuId("hotelList"),this.setDetailType("hotel")}}}).call(e,i("7t+N"))}});