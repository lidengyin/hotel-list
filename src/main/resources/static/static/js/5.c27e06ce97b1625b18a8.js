webpackJsonp([5],{"/hcw":function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=a("mrTZ"),o={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"myRoomInfo",attrs:{"element-loading-text":"en"==t.primaryLangID?"Loading":"酒店数据加载中"}},[t.rooms&&t.rooms.length?a("div",{staticClass:"myHotelDetail-mainContentDiv"},[a("div",{staticClass:"myHotelDetail-mainRoomDiv"},[t._l(t.rooms,function(e,i){return a("div",{key:i,staticClass:"myHotelDetail-mainRoomItem"},[a("div",{staticClass:"navDiv"},[a("h2",[t._v(t._s(e.roomTypeInfo.roomTypeName))])]),t._v(" "),a("div",{staticClass:"hotelInfoDiv"},[a("ul",{staticClass:"infoUl"},[a("li",{staticClass:"infoLi overnone"},[a("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.floor"))+"：")]),t._v("\n                "+t._s(e.roomTypeInfo.floorRange)+t._s("en"==t.primaryLangID?"F":"楼")+"\n              ")]),t._v(" "),a("li",{staticClass:"infoLi overnone"},[a("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.window"))+"：")]),t._v("\n                "+t._s(t.getWindows(e.roomTypeInfo.hasWindow))+"\n              ")]),t._v(" "),a("li",{staticClass:"infoLi overnone"},[a("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.area"))+"：")]),t._v("\n                "+t._s(e.roomTypeInfo.areaRange)+"m²\n              ")]),t._v(" "),a("li",{staticClass:"infoLi overnone"},[a("span",{staticClass:"infoLiSpan"},[t._v(t._s(t.$t("m.roomsNumber"))+"：")]),t._v("\n                "+t._s(e.roomTypeInfo.roomQuantity)+t._s("en"==t.primaryLangID?"":"间")+"\n              ")])]),t._v(" "),a("div",{staticClass:"statementDiv"},[e.roomTypeInfo.descriptions&&e.roomTypeInfo.descriptions.length>0?a("div",{staticClass:"descriptions"},[a("span",{staticClass:"descriptionsSpan",staticStyle:{width:"100px!important"}},[t._v("\n                  "+t._s(t.$t("m.description"))+"：\n                ")]),t._v(" "),a("div",{staticClass:"descriptionsDiv",staticStyle:{width:"calc(100% - 115px)","margin-left":"115px"}},t._l(e.roomTypeInfo.descriptions,function(e,o){return e.text?a("span",{key:o,staticStyle:{display:"block","margin-left":"15px"},attrs:{id:"roomDescriptions"+i+o}},[t._v(t._s(t.formatterDescription1("roomDescriptions"+i+o,e)))]):t._e()}),0)]):t._e(),t._v(" "),e.roomTypeInfo.facilities&&e.roomTypeInfo.facilities.length>0?a("div",{staticClass:"descriptions",staticStyle:{margin:"30px 0!important"}},[a("span",{staticClass:"descriptionsSpan",staticStyle:{width:"100px!important"}},[t._v("\n                  "+t._s(t.$t("m.facilities"))+"：\n                ")]),t._v(" "),a("div",{staticClass:"descriptionsDiv",staticStyle:{width:"calc(100% - 115px)","margin-left":"115px"}},[a("span",t._l(e.roomTypeInfo.facilities,function(e,i){return a("ul",{key:i,staticClass:"facilitieUl"},[a("span",{staticClass:"leftTitle"},[t._v("\n                        "+t._s(e.categoryName)+"：\n                      ")]),t._v(" "),a("span",{staticClass:"rightContent"},t._l(e.facilityItem,function(e,i){return 0!=e.status&&e.name?a("li",{key:i,staticClass:"facilitieLi"},[a("span",[t._v(t._s(e.name)+t._s(1==e.status?"":"en"==t.primaryLangID?"(Some)":"（部分有）"))])]):t._e()}),0)])}),0)])]):t._e()])]),t._v(" "),e.roomTypeInfo.pictures.length>0?a("div",{staticClass:"roomImage"},[a("p",[t._v(t._s(t.$t("m.roomPictures"))+"：")]),t._v(" "),a("div",{staticClass:"hotelImagesDiv"},t._l(e.roomTypeInfo.pictures,function(t,e){return a("el-image",{key:e,attrs:{src:t.uRL}})}),1)]):t._e(),t._v(" "),e.roomInfos?a("div",[e.roomInfos.roomInfo&&e.roomInfos.roomInfo.length>0?a("div",{staticClass:"allRoomOfTypeDiv"},[a("p",{staticStyle:{"margin-top":"20px","font-weight":"bold","margin-bottom":"25px","font-size":"16px"}},[t._v(t._s(t.$t("m.sellingTheHouseType"))+"：")]),t._v(" "),a("ul",{staticClass:"allRoomUl",staticStyle:{"border-top":"1px solid rgb(144,144,144)"}},[a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"15%",height:"50px!important","line-height":"50px!important"}},[t._v("\n                  "+t._s(t.$t("m.roomName"))+"\n                ")]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"10%",height:"50px!important","line-height":"50px!important"}},[t._v("\n                  "+t._s(t.$t("m.meal"))+"\n                ")]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"12%",height:"50px!important","line-height":"50px!important"}},[t._v("\n                  "+t._s(t.$t("m.numberOfTheGuest"))+"\n                ")]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"18%",height:"50px!important","line-height":"50px!important"}},[t._v("\n                  "+t._s(t.$t("m.facilityServices"))+"\n                ")]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"20%",height:"50px!important","line-height":"50px!important"}},[t._v("\n                  "+t._s(t.$t("m.smokelessMeasures"))+"\n                ")]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"10%",height:"50px!important","line-height":"50px!important"}},[t._v("\n                  "+t._s(t.$t("m.policies"))+"\n                ")]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"8%",height:"50px!important","line-height":"50px!important"}},[t._v("\n                  "+t._s(t.$t("m.rate"))+"\n                ")]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"7%",height:"50px!important","line-height":"50px!important"}})]),t._v(" "),t._l(e.roomInfos.roomInfo,function(i,o){return i.ratePlan&&i.ratePlan.rates&&i.ratePlan.rates.length?a("ul",{key:o,staticClass:"allRoomUl",on:{click:function(e){return t.showa(i)}}},[a("li",{staticClass:"allRoomLi",staticStyle:{width:"15%"}},[a("div",{staticClass:"myDiv",staticStyle:{"text-align":"left","margin-left":"10%"}},[t._v("\n                    "+t._s(i.roomName.slice(0,t.getRoomName(i.roomName)))+"\n                    "),a("span",{staticStyle:{color:"rgb(132,193,255)"}},[t._v(t._s(i.roomName.slice(t.getRoomName(i.roomName),i.roomName.length)))])])]),t._v(" "),a("li",{staticClass:"allRoomLi",staticStyle:{width:"10%"}},[a("div",{staticClass:"myDiv"},[a("p",{staticClass:"allRoomP"},[t._v(t._s(t.formatterMeal(i.ratePlan)))])])]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"12%"}},[a("div",{staticClass:"myDiv"},[a("p",{directives:[{name:"show",rawName:"v-show",value:i.maxAudltOccupancy&&"zh-cn"==t.primaryLangID,expression:"typeRoom.maxAudltOccupancy && primaryLangID == 'zh-cn'"}],staticClass:"allRoomP"},[t._v("最多入住"+t._s(i.maxAudltOccupancy)+"个成人")]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:i.maxChildrenOccupancy&&"zh-cn"==t.primaryLangID,expression:"typeRoom.maxChildrenOccupancy && primaryLangID == 'zh-cn'"}],staticClass:"allRoomP"},[t._v("最多入住"+t._s(i.maxChildrenOccupancy)+"名儿童")]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:i.maxAudltOccupancy&&"en"==t.primaryLangID,expression:"typeRoom.maxAudltOccupancy && primaryLangID == 'en'"}],staticClass:"allRoomP"},[t._v(t._s("Maximum ")+" "+t._s(i.maxAudltOccupancy)+t._s(" adults"))]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:i.maxChildrenOccupancy&&"en"==t.primaryLangID,expression:"typeRoom.maxChildrenOccupancy && primaryLangID == 'en'"}],staticClass:"allRoomP"},[t._v(t._s("Maximum ")+t._s(i.maxChildrenOccupancy)+" "+t._s(" children"))])])]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"18%"}},[a("div",{staticClass:"myDiv"},[1!=i.broadNet.hasBroadnet?a("p",{staticClass:"allRoomP"},[t._v(t._s("en"==t.primaryLangID?"No broadband":"没有宽带"))]):t._e(),t._v(" "),"-100"!=i.extraBedFee?a("p",{staticClass:"allRoomP"},[t._v(t._s((t.primaryLangID,t.getBedFee(i.ratePlan,i.extraBedFee))))]):t._e(),t._v(" "),1==i.broadNet.hasBroadnet?a("p",{staticClass:"allRoomP"},[t._v(t._s(t.getNet(i.broadNet,1)))]):t._e(),t._v(" "),1==i.broadNet.hasBroadnet?a("p",{staticClass:"allRoomP"},[t._v(t._s(t.getNet(i.broadNet,2)))]):t._e()])]),t._v(" "),a("li",{staticClass:"allRoomLi overnone",staticStyle:{width:"20%"}},[a("div",{staticClass:"myDiv"},[a("p",{directives:[{name:"show",rawName:"v-show",value:"T"==i.smoking.notAllowSmoking,expression:"typeRoom.smoking.notAllowSmoking == 'T'"}],staticClass:"allRoomP"},[t._v(t._s("en"==t.primaryLangID?"Smoking Ban":"禁烟"))]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:"T"!=i.smoking.notAllowSmoking&&i.smoking.isAllowSmoking&&2!=i.smoking.isAllowSmoking,expression:"typeRoom.smoking.notAllowSmoking != 'T' && typeRoom.smoking.isAllowSmoking && typeRoom.smoking.isAllowSmoking != 2"}],staticClass:"allRoomP"},[t._v("\n                      "+t._s(3==i.smoking.isAllowSmoking?"en"==t.primaryLangID?"Some rooms":"部分客房":"")+t._s("en"==t.primaryLangID?"can smoking":"可吸烟")+"\n                    ")]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:("T"!=i.smoking.notAllowSmoking||i.smoking.isAllowSmoking&&2!=i.smoking.isAllowSmoking)&&"T"==i.smoking.hasDeoderizedRoom,expression:"(typeRoom.smoking.notAllowSmoking != 'T' || (typeRoom.smoking.isAllowSmoking && typeRoom.smoking.isAllowSmoking != 2)) && typeRoom.smoking.hasDeoderizedRoom == 'T'"}],staticClass:"allRoomP"},[t._v("\n                      "+t._s(t.getSmoking(i.smoking))+"\n                    ")])])]),t._v(" "),a("li",{staticClass:"allRoomLi",staticStyle:{width:"10%"}},[a("div",{staticClass:"myDiv"},[t.formatterRatePlan(i.ratePlan,4)?t._e():a("p",{staticClass:"allRoomP"},[t._v(t._s(t.formatterRatePlan(i.ratePlan,1)))]),t._v(" "),t.formatterRatePlan(i.ratePlan,4)?a("p",{staticClass:"allRoomP",staticStyle:{cursor:"pointer",color:"#5bc0de"},attrs:{title:t.formatterRatePlan(i.ratePlan,2)}},[t._v(t._s(t.formatterRatePlan(i.ratePlan,1)))]):t._e(),t._v(" "),a("p",{staticClass:"allRoomP"},[t._v(t._s(t.formatterRatePlan(i.ratePlan,3)))])])]),t._v(" "),a("li",{staticClass:"allRoomLi",staticStyle:{width:"8%"}},[a("div",{staticClass:"myDiv"},[i.ratePlan?a("p",{staticClass:"allRoomP",staticStyle:{color:"rgb(255,154,20)","font-weight":"bold","font-size":"16px"}},[t._v(t._s(t.formatterPrice(i.ratePlan)))]):t._e()])]),t._v(" "),a("li",{staticClass:"allRoomLi",staticStyle:{width:"7%"}},[t.formatterRoomOrderTime(i.ratePlan).start>t.myTime||t.formatterRoomOrderTime(i.ratePlan).end<t.myTime?a("div",{staticClass:"myDiv"},[t.formatterRoomStatus(i.ratePlan)?a("el-button",{staticStyle:{"font-size":"14px"},attrs:{type:"text",disabled:!0},on:{click:function(a){return t.goToOrderRoom(e,i)}}},[t._v(t._s(t.$t("m.outTime")))]):t._e()],1):a("div",{staticClass:"myDiv"},[a("el-button",{attrs:{type:"text"},on:{click:function(a){return t.goToOrderRoom(e,i)}}},[t._v(t._s(t.$t("m.book")))]),t._v(" "),t.formatterRoomStatus(i.ratePlan)<10?a("span",{staticClass:"noselect roomTipSpan"},[t._v("\n                      "+t._s("en"==t.primaryLangID?"Inventory nervous":"房型紧张")+"\n                    ")]):t._e()],1)])]):t._e()})],2):t._e()]):t._e()])}),t._v(" "),t.rooms&&t.rooms.length&&"end"!=t.recordId[2]&&1==t.hoteltype?a("div",{staticClass:"myPages"},[a("el-row",[a("el-button",{attrs:{type:"primary",icon:"el-icon-arrow-left",plain:"",disabled:"0"==t.recordId[t.pageNum]},on:{click:function(e){return t.handleCurrentChange("last")}}},[t._v(t._s(t.$t("m.last")))]),t._v(" "),a("el-button",{attrs:{type:"primary",plain:"",disabled:"end"==t.recordId[t.pageNum+1]},on:{click:function(e){return t.handleCurrentChange("next")}}},[t._v(t._s(t.$t("m.next"))),a("i",{staticClass:"el-icon-arrow-right el-icon--right"})])],1)],1):t._e()],2)]):t._e(),t._v(" "),t.noDate?a("div",{staticClass:"myHotelDetail-mainContentDiv"},[a("div",{staticClass:"myHotelDetail-emptyDiv"},[a("Empty",{attrs:{message:"暂无房型信息"}})],1)]):t._e()])},staticRenderFns:[]};var n=function(t){a("KE+r")},s=a("VU/8")(i.a,o,!1,n,null,null);e.default=s.exports},"KE+r":function(t,e){},mrTZ:function(t,e,a){"use strict";(function(t){var i=a("Xxa5"),o=a.n(i),n=a("NC6I"),s=a.n(n),r=a("D2Ra"),l=a("NYxO"),m=a("kw8N"),c=(a.n(m),a("OXi9")),p=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var a=arguments[e];for(var i in a)Object.prototype.hasOwnProperty.call(a,i)&&(t[i]=a[i])}return t};function d(t){return function(){var e=t.apply(this,arguments);return new Promise(function(t,a){return function i(o,n){try{var s=e[o](n),r=s.value}catch(t){return void a(t)}if(!s.done)return Promise.resolve(r).then(function(t){i("next",t)},function(t){i("throw",t)});t(r)}("next")})}}e.a={name:"",components:{Empty:c.a},data:function(){return{show:!0,noDate:!1,activeId:"info",hotelID:"",extendedNode:["RoomTypeInfo.Descriptions","RoomTypeInfo.Facilities","RoomInfo.ApplicabilityInfo","RoomInfo.Smoking","RoomInfo.BroadNet","RoomInfo.RoomBedInfos","RoomTypeInfo.Pictures"],hoteltype:1,recordId:["0","0"],pageNum:0,pageSize:50,Rooms:[],rooms:[],myTime:0,loading:!1}},methods:p({},Object(l.b)(["choiceMenuId","setDetailType"]),{returnHeaders:function(t){var e=(new Date).getTime()+"",a={timestamp:e,interfacekey:"15456a8b-f9b3-4e39-83cf-7186b9cb6336",requesttype:t,signature:s()(e+109+s()("15456a8b-f9b3-4e39-83cf-7186b9cb6336").toUpperCase()+104+t).toUpperCase(),"Content-Type":"application/json;charset=UTF-8"};return this.hoteltype?a.hoteltype="3":a.masterhotelmode="T",a},handleCurrentChange:function(t){this.reqHotelsRoomStatic(t)},showa:function(t){console.log(t)},reqHotelsRoomStatic:function(t){var e=this;return d(o.a.mark(function a(){var i,n,s,l,m,c,p,u,y,h,f,g,v,_,I;return o.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:if(e.hoteltype&&("last"==t?e.pageNum--:"next"==t&&e.pageNum++),i=e.hotelID,n=e.extendedNode,s=e.primaryLangID,l=e.pageSize,m=e.recordId,c=e.pageNum,p=e.hoteltype,u=m[c],y=e.returnHeaders("GET_HOTEL_ROOM_STATICINFO"),h={hotelID:i},f={primaryLangID:s,extendedNodes:{extendedNode:n}},g={pageSize:l,lastRecordID:u},e.loading=!0,!p){a.next=15;break}return a.next=12,Object(r.l)({searchCandidate:h,settings:f,pagingSettings:g},y);case 12:v=a.sent,a.next=18;break;case 15:return a.next=17,Object(r.l)({searchCandidate:h,settings:f},y);case 17:v=a.sent;case 18:e.loading=!1,(_=v.ResponseStatus)&&0==_.Errors.length?("next"==t&&p&&(u=v.pagingSettings&&v.pagingSettings.lastRecordID||"end",e.recordId[e.pageNum+1]=u),console.log(v),v.roomStaticInfos?(e.rooms=v.roomStaticInfos.roomStaticInfo||[],console.log(e.rooms),e.rooms&&e.rooms.length&&e.rooms.map(function(){var t=d(o.a.mark(function t(a){var i,n,s;return o.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:a.roomInfos&&a.roomInfos.roomInfo&&a.roomInfos.roomInfo.map(function(){var t=d(o.a.mark(function t(a){return o.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.t0=e,t.t1=a,t.next=4,e.reqRatePlan(a.roomID);case 4:t.t2=t.sent,t.t0.$set.call(t.t0,t.t1,"ratePlan",t.t2);case 6:case"end":return t.stop()}},t,e)}));return function(e){return t.apply(this,arguments)}}()),a.roomTypeInfo.pictures&&(i=a.roomTypeInfo.pictures).picture?a.roomTypeInfo.pictures=i.picture.filter(function(t){return"HOTEL"==t.source}).slice(0,10):a.roomTypeInfo.pictures=[],a.roomTypeInfo.descriptions?(n=a.roomTypeInfo.descriptions,a.roomTypeInfo.descriptions=n.description||[],a.roomTypeInfo.descriptions=a.roomTypeInfo.descriptions.filter(function(t){t.text})):a.roomTypeInfo.descriptions=[],(s=a.roomTypeInfo.facilities||{})&&s.facility?a.roomTypeInfo.facilities=e.getFacilities(s.facility):a.roomTypeInfo.facilities={};case 5:case"end":return t.stop()}},t,e)}));return function(e){return t.apply(this,arguments)}}())):e.rooms=[]):(e.rooms=[],I="获取酒店静态房型信息失败，请刷新重试",e.message(I,"error",1200)),0==e.rooms.length&&(e.noDate=!0);case 22:case"end":return a.stop()}},a,e)}))()},reqRatePlan:function(t){var e=this;return d(o.a.mark(function a(){var i,n,s,l,m,c,p,d,u;return o.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return i=e.hotelID,n=e.dateToStr(new Date)+" 00:00:00",s=e.dateToStr(new Date((new Date).getTime()+864e5))+" 00:00:00",l=e.returnHeaders("GET_HOTEL_RATEPLAN"),(m=[]).push(t),c={hotelID:i,roomID:m,dateRange:{start:n,end:s}},a.next=10,Object(r.k)({searchCandidate:c},l);case 10:return p=a.sent,d=p.ResponseStatus,u={},d&&0==d.Errors.length&&p.ratePlans&&p.ratePlans.length&&(u=p.ratePlans[0]),a.abrupt("return",u);case 15:case"end":return a.stop()}},a,e)}))()},getWindows:function(t){var e="";return"en"==this.primaryLangID?(e="Yes",0==t?e="No":1==t?e="Some have a window":-100==t&&(e="Unknow")):(e="有窗",0==t?e="无窗":1==t?e="部分有窗":-100==t&&(e="未知")),e},formatterDescription1:function(e,a){setTimeout(function(){t("#"+e).html(a.text)},300)},getFacilities:function(t){var e=[];return t.map(function(t){var a=!1;if(e.map(function(e){e.categoryName==t.categoryName&&(a=!0,t.facilityItem.map(function(t){e.facilityItem.push(t)}))}),!a){var i={categoryName:t.categoryName,facilityItem:[]};t.facilityItem.map(function(t){i.facilityItem.push(t)}),e.push(i)}}),e},getBedFee:function(t,e){var a="",i="CNY";if(e*=1,t){var o=t.rates;o&&o.length&&(o=o[0]).price&&(i=o.price.currency)}return"en"==this.primaryLangID?0==e?a="Free extra bed":e>0?a="extra bed("+i+" "+e+")":-1==e&&(a="No extra bed"):0==e?a="免费加床":e>0?a="可加床("+i+" "+e+")":-1==e&&(a="不加床"),a},getNet:function(t,e){var a="",i="";return"T"==t.hasWiredBroadnet&&1==e&&(1!=t.wiredBroadnetRoom?(a="部分房间有线宽带",i="Some rooms are wired with broadband"):(a="全部房间有线宽带",i="All rooms are wired with broadband"),1==t.wirelessBroadnetFee?(a+="（收费）",i+="(Not free)"):(a+="（免费）",i+="(Free)")),"T"==t.hasWirelessBroadnet&&2==e&&(1!=t.wirelessBroadnetRoom?(a="部分房间无线宽带",i="Wireless broadband in some rooms"):(a="全部房间无线宽带",i="Wireless broadband in all rooms"),1==t.wirelessBroadnetFee?(a+="（收费）",i+="(Not free)"):(a+="（免费）",i+="(Free)")),"en"==this.primaryLangID?i:a},getSmoking:function(t){var e="",a="";return"T"==t.hasNonSmokingRoom&&(e="该房型有无烟房",a="","T"==t.hasRoomInNonSmokingArea&&(e+="，可安排无烟楼层",a+="can arrange no-smoking floor")),"en"==this.primaryLangID?a:e},getRoomName:function(t){var e=t.indexOf("("),a=t.indexOf("[");return-1!=e&&-1!=a?e<a?e:a:-1==e&&-1!=a?a:-1==a&&-1!=e?e:t.length},formatterMeal:function(t){var e="en"==this.primaryLangID?"No meal":"无餐";if(t){var a=t.rates;a&&a.length&&(a=a[0]).mealsIncluded&&10!=a.mealsIncluded.mealType&&a.mealsIncluded.mealCount>0&&(0==a.mealsIncluded.mealType?e="en"==this.primaryLangID?"with meal":"含餐":1==a.mealsIncluded.mealType?e="en"==this.primaryLangID?"breakfast":"早餐":2==a.mealsIncluded.mealType?e="en"==this.primaryLangID?"lunch":"中餐":3==a.mealsIncluded.mealType?e="en"==this.primaryLangID?"dinner":"晚餐":6==a.mealsIncluded.mealType?e="en"==this.primaryLangID?"breakfast + lunch":"早+中":7==a.mealsIncluded.mealType?e="en"==this.primaryLangID?"breakfast + dinner":"早+晚":8==a.mealsIncluded.mealType?e="en"==this.primaryLangID?"full meal":"全餐":9==a.mealsIncluded.mealType&&(e="en"==this.primaryLangID?"lunch + dinner":"中+晚"),e=a.mealsIncluded.mealCount+("en"==this.primaryLangID?" ":"份")+e)}return e},formatterRatePlan:function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,a="";if(t){var i,o=t.saleRule,n=t.cancelPolicies;if(n&&n.length>0&&1==e)a=(i=n[0]).canCancel?"zh-cn"==this.primaryLangID?i.lastDate>0?"最晚入住前"+i.lastDate+"天"+i.lastTime+"可取消订单":"最晚入住当天"+i.lastTime+"前可取消订单":i.lastDate>0?"The order can be cancelled at "+i.lastTime+" "+i.lastDate+" before the latest check-in time":"The order can be cancelled at "+i.lastTime+" on the latest check-in day":"zh-cn"==this.primaryLangID?"不可取消":"irrevocable";if(n&&n.length>0&&2==e)(i=n[0]).canCancel&&("zh-cn"==this.primaryLangID?0==i.deductType?a="免费取消":1==i.deductType?a="取消扣全款":2==i.deductType?a="取消扣首晚房费":3==i.deductType&&(a="取消扣房费"+i.deductProportion+"%"):0==i.deductType?a="Free cancellation":1==i.deductType?a="Cancellation charge full deduction":2==i.deductType?a="Cancellation charge the first night room ":3==i.deductType&&(a="Cancellation charge"+i.deductProportion+"%of room rate"));if(o&&3==e&&o.checkQunarNOLimit&&(0==o.limitType?"zh-cn"==this.primaryLangID?0==o.limitDay?a="当天"+o.limitTime+"前预订":o.limitDay>0&&(a="提前"+o.limitDay+"天"+o.limitTime+"前预订"):0==o.limitDay?a="Book by "+o.limitTime+" that day":o.limitDay>0&&(a="Book "+o.limitDay+o.limitDay>1?" days ":" day in advance by "+o.limitTime):1==o.limitType&&("zh-cn"==this.primaryLangID?0==o.limitDay?a="当天"+o.limitTime+"后预订":o.limitDay>0&&(a="提前"+o.limitDay+"天"+o.limitTime+"后预订"):0==o.limitDay?a="Book after "+o.limitTime+" that day":o.limitDay>0&&(a="Book "+o.limitDay+o.limitDay>1?" days ":" day in advance after "+o.limitTime))),n&&n.length>0&&4==e)a=!!(i=n[0]).canCancel}return a},formatterPrice:function(t){var e="";if(t){var a=t.rates;a&&a.length&&(a=a[0]).price&&(e=a.price.currency+" "+a.price.inclusiveAmount)}return e},formatterRoomStatus:function(t){var e=0;if(t){var a=t.rates;a&&a.length&&(e=(a=a[0]).numberOfUnits),1==a.saleStatus&&0==e&&(e=1)}return e},formatterRoomOrderTime:function(t){var e=new Date,a=(e=new Date(e.getFullYear(),e.getMonth(),e.getDate())).getTime(),i={start:a,end:a+864e5-1e3};if(t){var o=t.saleRule;if(o&&o.checkQunarNOLimit&&o.StartTime&&o.EndTime){var n=1*o.StartTime.slice(0,2),s=1*o.StartTime.slice(3,5),r=1*o.EndTime.slice(0,2),l=1*o.EndTime.slice(3,5);o.EndTimeType?i.end=i.start+864e5+60*r*60*1e3+60*l*1e3:i.end=i.start+60*r*60*1e3+60*l*1e3,i.start+=60*n*60*1e3+60*s*1e3}}return i},goToOrderRoom:function(t,e){console.log(t),console.log(e);var a=this.hotelID,i=e.roomName,o=e.roomID,n=e.maxAudltOccupancy,s=e.ratePlan,r=t.roomTypeInfo.roomTypeID,l=s.saleRule,m=s.rates[0],c=m.saleStatus,p=m.numberOfUnits,d=l.maxBookRoomCount,u=l.maxContinueDay,y=l.minBookRoomCount,h=l.minContinueDay,f=l.endTimeType,g=l.checkQunarNOLimit,v=l.limitDay,_=l.limitType,I=l.limitTime;y||(y=1),h||(h=0),d||(d=9999),u||(u=9999),f||(f=0),g||(g=!1),0!=_&&1!=_&&(_=!1),(0!=v&&v<1||void 0==v)&&(v=!1),I||(I=!1),a&&o&&r&&this.$router.push({name:"orderRoom",query:{hotelID:JSON.stringify(a),roomID:JSON.stringify(o),roomName:JSON.stringify(i),roomTypeID:JSON.stringify(r),maxAudltOccupancy:JSON.stringify(n),minBookRoomCount:JSON.stringify(y),minContinueDay:JSON.stringify(h),endTimeType:JSON.stringify(f),maxBookRoomCount:JSON.stringify(d),maxContinueDay:JSON.stringify(u),saleStatus:JSON.stringify(c),numberOfUnits:JSON.stringify(p),checkQunarNOLimit:JSON.stringify(g),limitDay:JSON.stringify(v),limitType:JSON.stringify(_),limitTime:JSON.stringify(I),hoteltype:JSON.stringify(this.hoteltype)}})},dateToStr:function(t){var e=t.getFullYear(),a=t.getMonth()+1,i=t.getDate();return a<10&&(a="0"+a),i<10&&(i="0"+i),e+"-"+a+"-"+i},message:function(t,e,a){this.$message({message:t,duration:a,type:e})}}),watch:{primaryLangID:function(t,e){this.rooms=[],this.reqHotelsRoomStatic()}},computed:p({},Object(l.c)(["primaryLangID"])),created:function(){this.$route.query.hotelID?(this.hotelID=JSON.parse(this.$route.query.hotelID),this.hoteltype=JSON.parse(this.$route.query.hoteltype),this.myTime=(new Date).getTime(),this.reqHotelsRoomStatic()):this.$router.go(-1)},mounted:function(){this.choiceMenuId("hotelList"),this.setDetailType("room")},destroyed:function(){clearInterval(this.myTimeInterval)}}}).call(e,a("7t+N"))}});