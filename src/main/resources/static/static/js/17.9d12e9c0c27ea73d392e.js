webpackJsonp([17],{DDe1:function(e,t){},oVGN:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=a("Xxa5"),s=a.n(i),r=a("NC6I"),n=a.n(r),o=a("D2Ra"),l=a("NYxO"),c=(a("kw8N"),Object.assign||function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var i in a)Object.prototype.hasOwnProperty.call(a,i)&&(e[i]=a[i])}return e});function m(e){return function(){var t=e.apply(this,arguments);return new Promise(function(e,a){return function i(s,r){try{var n=t[s](r),o=n.value}catch(e){return void a(e)}if(!n.done)return Promise.resolve(o).then(function(e){i("next",e)},function(e){i("throw",e)});e(o)}("next")})}}var h={name:"",components:{},data:function(){return{hoteltype:1,hotelID:"",roomID:"",roomTypeID:"",maxAudltOccupancy:1,roomName:"",minBookRoomCount:0,minContinueDay:0,maxBookRoomCount:0,maxContinueDay:0,endTimeType:0,saleStatu:2,checkQunarNOLimit:!1,limitDay:"",limitType:"",limitTime:"",start:"",end:"",start1:"",end1:"",dateError:"",quantityError:"",availMessage:{},ratePlans:[],numberOfUnits:3,roomNums:[],quantity:1,oldquantity:1,persons:[{name:""}],phone:"",name:"",contactPerson:[{phoneTechType:4,phoneNumber:""}],phoneTechTypes:[{phoneTechType:1,name:"语音电话"},{phoneTechType:2,name:"传真"},{phoneTechType:3,name:"手机"},{phoneTechType:4,name:"邮箱"}],lastArrivalTime:"12:00",payType:"PP",remark:"",everydayPrices:[],cancelPenalty:[],totalAmount:0,currency:0,loading:!1,dateLoading:!1,availLoading:!1,dialogTableVisible:!1,phoneError:"",otherError:"",lastArrivalTimeError:"",status:!1,orderInfo:"",error:!1}},methods:c({},Object(l.b)(["choiceMenuId"]),{returnHeaders:function(e){var t=(new Date).getTime()+"",a={timestamp:t,interfacekey:"15456a8b-f9b3-4e39-83cf-7186b9cb6336",requesttype:e,signature:n()(t+109+n()("15456a8b-f9b3-4e39-83cf-7186b9cb6336").toUpperCase()+104+e).toUpperCase(),"Content-Type":"application/json;charset=UTF-8"};return this.hoteltype?a.hoteltype="3":a.masterhotelmode="T",a},getUuid:function(){return(65536*(1+Math.random())|0).toString(16).substring(1)},guid:function(){return this.getUuid()+this.getUuid()},reqRatePlan:function(){var e=this;return m(s.a.mark(function t(){var a,i,r,n,l,c,m,h,u,p,d,v,y;return s.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return a=e.hotelID,i=e.roomID,r=e.start1,n=e.end1,l=(n.getTime()-r.getTime())/864e5+1,c=e.dateToStr(r,3),m=e.dateToStr(n,3),h=e.returnHeaders("GET_HOTEL_RATEPLAN"),u=i,(i=[]).push(u),p={hotelID:a,roomID:i,dateRange:{start:c,end:m}},e.dateLoading=!0,t.next=13,Object(o.k)({searchCandidate:p},h);case 13:d=t.sent,e.dateLoading=!1,v=d.ResponseStatus,y="",v&&0==v.Errors.length?d.ratePlans?(y=d.ratePlans[0]||[],console.log(y.rates),console.log(l),y&&y.rates&&y.rates.length==l?(y.rates=y.rates.slice(0,y.rates.length-1),y.rates.map(function(t){if(t.effectiveDate){var a=new Date(1*t.effectiveDate.slice(t.effectiveDate.indexOf("(")+1,t.effectiveDate.indexOf("+")));t.datetime=e.dateToStr(a,3)}}),e.start=r,e.end=n,e.ratePlans=y,e.cancelPenalty=y.cancelPolicies[0]||[],console.log(y)):(e.dialogTableVisible=!0,e.dateError="您所选择的部分入住日期满房或不满足促销条件，请修改日期或重新选择房型")):(e.dialogTableVisible=!0,e.dateError="您所选择的部分入住日期满房或不满足促销条件，请修改日期或重新选择房型"):e.error=!0;case 18:case"end":return t.stop()}},t,e)}))()},reqHotelAvail:function(){var e=this;return m(s.a.mark(function t(){var a,i,r,n,l,c,m,h,u,p,d,v,y,g,f,T,_;return s.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return a=e.hotelID,i=e.roomTypeID,r=e.roomID,n=e.oldquantity,l=e.start,c=e.end,m=e.totalAmount,h=e.everydayPrices,u=e.lastArrivalTime,p=e.maxAudltOccupancy,a+="",l=e.dateToStr(l,3),c=e.dateToStr(c,3),m=e.getEverydayPrices(h,n),d=e.returnHeaders("HOTEL_AVAIL","3"),y={hotelID:a,roomID:r,roomTypeID:i,quantity:v=n,persons:v*p,dateRange:{start:l,end:c},everydayPrices:h,totalAmount:m,lastArrivalTime:u},e.availLoading=!0,t.next=13,Object(o.p)(y,d);case 13:if(g=t.sent,e.availLoading=!1,(f=g.ResponseStatus)&&0==f.Errors.length)if(console.log(g),g.status)if(e.quantity=n,e.everydayPrices=g.everydayPrices,-1!=g.availableRooms?e.numberOfUnits=g.availableRooms:e.numberOfUnits=99,e.setMinMaxRooms1(),e.getRoomNums(),g.cancelPenalty&&(e.cancelPenalty=g.cancelPenalty),e.reSetEverydayPrices(),e.status=g.status,v>e.persons.length)for(T=e.persons.length;T<v;T++)e.persons.push({name:""});else e.persons=e.persons.slice(0,v);else e.status=g.status,_=g.message,e.$alert(_.message,"提示",{confirmButtonText:"确定",callback:function(e){console.log(_.message)}});else e.oldquantity=e.quantity,e.status=!1;case 17:case"end":return t.stop()}},t,e)}))()},createOrder:function(){var e=this;return m(s.a.mark(function t(){var a,i,r,n,l,c,m,h,u,p,d,v,y,g,f,T,_,D,C,b,I,S,E,L,P,k,O,x,q;return s.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(a=e.hotelID,i=e.roomID,r=e.start,n=e.end,l=e.persons,c=e.quantity,m=e.phone,h=e.name,u=e.contactPerson,p=e.payType,d=e.everydayPrices,v=e.totalAmount,y=e.lastArrivalTime,g=e.remark,f=e.roomTypeID,T=e.currency,_=e.dateError,D=e.quantityError,C=e.phoneError,b=e.otherError,I=e.lastArrivalTimeError,!(_||D||C||b||I)){t.next=8;break}S="en"==e.primaryLangID?"There is a mistake in the information":"填写信息有错",e.message(S,"warning",2e3),t.next=29;break;case 8:if(E=0,l.map(function(e){e.name&&E++}),!(T&&a&&i&&r&&n&&E==c&&c&&m&&h&&u&&p&&d&&v&&y&&f)){t.next=27;break}return r=e.dateToStr(r,3),n=e.dateToStr(n,3),v={amount:v,currency:T},L=e.returnHeaders("CREATE_ORDER"),P={start:r,end:n},k=e.dateToStr(new Date,3),e.distributorOrderID=(new Date).getTime()+""+e.guid(),O=e.distributorOrderID,x={hotelID:a,roomID:i,roomTypeID:f,quantity:c,persons:l,distributorOrderID:O,name:h,phone:m,contactPerson:u,dateRange:P,orderDate:k,payType:p,everydayPrices:d,totalAmount:v,lastArrivalTime:y,remark:g},t.next=22,Object(o.d)({orderContent:x},L);case 22:q=t.sent,0==q.ResponseStatus.Errors.length?(q.orderInfo?e.orderInfo=q.orderInfo:e.orderInfo={},q.message&&(0!=q.message.code?(S=(S=q.message).message,4==q.message.code?(S+=",前往查看订单详情",e.$confirm(S,"提示",{confirmButtonText:"确定",type:"warning"}).then(function(){e.goToOrderDetail()})):e.$confirm(S,"警告",{confirmButtonText:"确定",type:"error"})):(S="创建订单成功",e.message(S,"success",2e3),setTimeout(function(){e.goToOrderDetail()},1e3)))):e.orderInfo={},t.next=29;break;case 27:S="en"==e.primaryLangID?"Please complete the required information":"请您先填完必填信息后再提交订单",e.message(S,"warning",2e3);case 29:case"end":return t.stop()}},t,e)}))()},setMinMaxRooms1:function(){var e=this.quantity,t=this.saleStatus,a=this.numberOfUnits;this.quantityError="",1!=t&&e>a&&(this.quantityError="en"==this.primaryLangID?"There is not enough room":"剩余房量不足")},setMinMaxRooms:function(){var e=this.minBookRoomCount,t=this.saleStatus,a=this.numberOfUnits;1==t?(this.quantity=e,this.oldquantity=e):(this.quantity=e,this.oldquantity=e,e>a&&(this.quantityError="en"==this.primaryLangID?"There is not enough room":"剩余房量不足"))},getRoomNums:function(){var e=this.minBookRoomCount,t=this.maxBookRoomCount,a=this.saleStatus,i=this.numberOfUnits,s=[];if(1==a){t>=100&&(t=99);for(var r=e;r<=t;r++)s.push({value:r})}else if(i<=t)for(r=e;r<=i;r++)s.push({value:r});else for(r=e;r<=t;r++)s.push({value:r});this.roomNums=s},setRoomNum:function(){var e=this.quantity,t=this.oldquantity;console.log(e,t);var a=t;this.oldquantity=e,this.quantity=a,this.quantityError="",this.reqHotelAvail()},getEverydayPrices:function(e,t){var a=0;return e.map(function(e){a+=e.inclusiveAmount}),Math.round(a*t*100)/100},setStartEndTime:function(){var e=this.checkQunarNOLimit,t=this.limitType,a=this.limitDay,i=this.limitTime,s=this.minContinueDay,r=new Date(this.dateToStr(new Date,1)),n=new Date;if(console.log(e,t,a,i,s),e){if(0==t)if(0==a)if(i){var o=1*i.slice(0,2),l=1*i.slice(3,5);1*n.getHours()>o||n.getHours()==o&&1*n.getMinutes()>=l?this.start=new Date(r.getTime()+864e5):this.start=r}else this.start=r;else this.limitDay>0&&(this.start=new Date(r.getTime()+864e5*a),console.log(this.start));else if(1==t)if(i){o=1*i.slice(0,2),l=1*i.slice(3,5);1*n.getHours()<o||n.getHours()==o&&1*n.getMinutes()<=l?this.start=new Date(r.getTime()+864e5):this.start=r}else this.start=r}else this.start=r;this.end=s?new Date(this.start.getTime()+864e5*s):new Date(this.start.getTime()+864e5),this.start1=this.start,this.end1=this.end,this.reqRatePlan()},openDate:function(){this.dateError="",this.dialogTableVisible=!0},reSetEverydayPrices:function(){var e=this;this.totalAmount=0;var t=0;this.currency="",console.log(this.everydayPrices),this.everydayPrices.map(function(a){var i=new Date(1*a.datetime.slice(a.datetime.indexOf("(")+1,a.datetime.indexOf("+")));a.datetime=e.dateToStr(i,3),0==a.mealCount&&(a.mealType=10),t+=a.inclusiveAmount,e.currency=a.currency}),this.totalAmount=Math.round(t*this.quantity*100)/100},testPhone:function(){var e=this.phone,t=this.primaryLangID;/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(e)?this.phoneError="":this.phoneError="en"==t?"Please enter the correct contact number":"请输入正确的联系电话"},setPhoneNumber:function(){this.otherError="",this.contactPerson[0].phoneNumber=""},testContactPerson:function(){var e=this.contactPerson,t=this.primaryLangID,a=e[0],i=a.phoneTechType,s=a.phoneNumber;1==i?/^(\d{3,4}-)\d{7,8}$/.test(s)?this.otherError="":this.otherError="en"==t?"Please enter the correct number":"请输入正确的电话":2==i?/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(s)?this.otherError="":this.otherError="en"==t?"Please enter the correct fax format":"请输入正确的传真格式：国家代码(2到3位，0/+/-开头)-区号(2到3位)-电话号码(7到8位)-分机号(3位)":3==i?/^1[3456789]\d{9}$/.test(s)?this.otherError="":(this.otherError="请输入正确的手机号码",this.otherError="en"==t?"Please enter the correct cell phone number":"请输入正确的手机号码"):4==i&&(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/.test(s)?this.otherError="":(this.otherError="请输入正确的邮箱",this.otherError="en"==t?"Please enter the correct email address":"请输入正确的邮箱"))},testLastArrivalTime:function(){var e=this.lastArrivalTime,t=this.primaryLangID,a=e.indexOf("：");if(a>0){var i=e.length;this.lastArrivalTime=e.slice(0,a)+":"+e.slice(a+1,i),e=this.lastArrivalTime}/^\d{2}\:\d{2}$/.test(e)?this.lastArrivalTimeError="":this.lastArrivalTimeError="en"==t?"Please enter the latest arrival time in the format":"请按格式输入最晚到达时间"},formatterRateMeal:function(e){var t=e.mealType,a=e.mealCount,i="en"==this.primaryLangID?"No meal":"无餐";return 10!=t&&a>0&&(0==t?i="en"==this.primaryLangID?"with meal":"含餐":1==t?i="en"==this.primaryLangID?"breakfast":"早餐":2==t?i="en"==this.primaryLangID?"lunch":"中餐":3==t?i="en"==this.primaryLangID?"dinner":"晚餐":6==t?i="en"==this.primaryLangID?"breakfast + lunch":"早+中":7==t?i="en"==this.primaryLangID?"breakfast + dinner":"早+晚":8==t?i="en"==this.primaryLangID?"full meal":"全餐":9==t&&(i="en"==this.primaryLangID?"lunch + dinner":"中+晚")),i},formatterRateMealCount:function(e){var t=e.mealCount,a="";return t&&(a=t+("en"==this.primaryLangID?" ":"份")),a},formatterRateConfirm:function(e){var t=!1;if(e){var a=e.rates;a&&a.length&&(a=a[0])&&a.isInstantConfirm&&(t=!0)}return t},formatterRatePlan:function(){var e="";return this.checkQunarNOLimit&&(0==this.limitType?"zh-cn"==this.primaryLangID?0==this.limitDay?e="当天"+this.limitTime+"前预定下单":this.limitDay>0&&(e="提前"+this.limitDay+"天预定下单"):0==this.limitDay?e="Book your order by "+this.limitTime+" that day":this.limitDay>0&&(e="Book "+this.limitDay+this.limitDay>1?" days ":" day in advance"):1==this.limitType&&("zh-cn"==this.primaryLangID?0==this.limitDay?e="当天"+this.limitTime+"后预定下单":this.limitDay>0&&(e="提前"+this.limitDay+"天预定下单"):0==saleRule.limitDay?e="Book your order after "+this.limitTime+" that day":this.limitDay>0&&(e="Book "+this.limitDay+this.limitDay>1?" days ":" day in advance"))),e},formatterCancelPenalty:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,a="";if(e){var i=e;1==t&&(a=i.canCancel?"zh-cn"==this.primaryLangID?i.lastDate>0?"最晚入住前"+i.lastDate+"天"+i.lastTime+"可取消订单":"最晚入住当天"+i.lastTime+"前可取消订单":i.lastDate>0?"The order can be cancelled at "+i.lastTime+" "+i.lastDate+" before the latest check-in time":"The order can be cancelled at "+i.lastTime+" on the latest check-in day":"zh-cn"==this.primaryLangID?"不可取消":"irrevocable"),2==t&&i.canCancel&&("zh-cn"==this.primaryLangID?0==i.deductType?a="免费取消":1==i.deductType?a="取消扣全款":2==i.deductType?a="取消扣首晚房费":3==i.deductType&&(a="取消扣房费"+i.deductProportion+"%"):0==i.deductType?a="Free cancellation":1==i.deductType?a="Cancellation charge full deduction":2==i.deductType?a="Cancellation charge the first night room ":3==i.deductType&&(a="Cancellation charge"+i.deductProportion+"%of room rate"))}return a},toChangeDate:function(){var e=this.start1,t=this.end1,a=this.minContinueDay,i=this.maxContinueDay,s=this.hoteltype,r=this.primaryLangID,n=new Date(this.dateToStr(new Date,1)),o=new Date,l=864e5;a&&(l=864e5*a);var c=8639136e5;if(i&&(c=864e5*i),e.getTime()>=n.getTime()){var m=!0;if(this.checkQunarNOLimit)if(0==this.limitType){if(0==this.limitDay){if(this.limitTime){var h=1*this.limitTime.slice(0,2),u=1*this.limitTime.slice(3,5);o.getTime()>=e.getTime()+36e5*h+60*u*100&&(m=!1,"en"==this.primaryLangID?this.dateError="Book your order by "+this.limitTime+" that day":this.dateError="当天"+this.limitTime+"前预定下单")}}else if(this.limitDay>0){if(this.limitTime)h=1*this.limitTime.slice(0,2),u=1*this.limitTime.slice(3,5);else h=23,u=59;o.getTime()+864e5*this.limitDay>=e.getTime()+36e5*h+60*u*100&&(m=!1,"en"==this.primaryLangID?this.dateError="Book "+this.limitDay+this.limitDay>1?" days ":" day in advance":this.dateError="请提前"+this.limitDay+"天预定下单")}}else if(1==this.limitType){if(this.limitTime)h=1*this.limitTime.slice(0,2),u=1*this.limitTime.slice(3,5);else h=0,u=0;(1*o.getHours()<h||o.getHours()==h&&1*o.getMinutes()<u)&&(m=!1,"en"==this.primaryLangID?this.dateError="Book your order after "+this.limitTime:this.dateError=this.limitTime+"后预定下单")}m&&(e&&t&&e.getTime()<t.getTime()&&e.getTime()>=n.getTime()?t.getTime()-e.getTime()<l?"en"==this.primaryLangID?this.dateError="Minimum "+a+" days":this.dateError="最小连住天数为"+a+"天":t.getTime()-e.getTime()>c?"en"==this.primaryLangID?this.dateError="Maximum "+i+" days":this.dateError="最大连住天数为"+i+"天":s?t.getTime()-e.getTime()>24192e5?this.dateError="en"==r?"If the check-in time exceeds 28 days,please submit your reservation by separate order.":"您入住酒店时间超过28天，请分订单提交预订。":(this.dialogTableVisible=!1,this.reqRatePlan()):t.getTime()-e.getTime()>7776e6?this.dateError="en"==r?"If the check-in time exceeds 90 days,please submit your reservation by separate order.":"您入住酒店时间超过90天，请分订单提交预订。":(this.dialogTableVisible=!1,this.reqRatePlan()):"en"==this.primaryLangID?this.dateError="Please choose the correct check-in and check-out time.":this.dateError="请选择正确的入住和退房时间。")}else"en"==this.primaryLangID?this.dateError="Please choose the correct check-in and check-out time.":this.dateError="请选择正确的入住和退房时间。"},cancleChangeDate:function(){this.start1=this.start,this.end1=this.end,this.dialogTableVisible=!1},goToOrderDetail:function(){var e=this.orderInfo,t=this.distributorOrderID;e&&e.orderID&&t&&this.$router.push({name:"orderDetail",query:{orderID:JSON.stringify(e.orderID),distributorOrderID:JSON.stringify(t)}})},dateToStr:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:2,a=e.getFullYear(),i=e.getMonth(),s=e.getMonth()+1,r=e.getDate(),n=e.getHours(),o=e.getMinutes(),l=e.getSeconds(),c=e.getDay();return i<10&&(i="0"+i),s<10&&(s="0"+s),r<10&&(r="0"+r),n<10&&(n="0"+n),o<10&&(o="0"+o),l<10&&(l="0"+l),"en"==this.primaryLangID?0==c?c="Sunday":1==c?c="Monday":2==c?c="Tuesday":3==c?c="Wednesday":4==c?c="Thursday":5==c?c="Friday":6==c&&(c="Saturday"):0==c?c="星期日":1==c?c="星期一":2==c?c="星期二":3==c?c="星期三":4==c?c="星期四":5==c?c="星期五":6==c&&(c="星期六"),1==t?a+"/"+s+"/"+r:2==t?a+"-"+s+"-"+r+c:a+"-"+s+"-"+r+" "+n+":"+o+":"+l},message:function(e,t,a){this.$message({message:e,duration:a,type:t})}}),watch:{ratePlans:function(e,t){var a=this;this.everydayPrices=[],this.status=!1,this.totalAmount=0,this.currency="";var i=1e4;if(e){var s=e.rates,r=[],n=0;s&&s.length&&s.map(function(e){var t={};t.datetime=e.datetime,t.inclusiveAmount=e.price.inclusiveAmount,t.currency=e.price.currency,t.mealCount=e.mealsIncluded.mealCount,0==t.mealCount?t.mealType=10:t.mealType=e.mealsIncluded.mealType,n+=t.inclusiveAmount,a.currency=t.currency,e.numberOfUnits<i&&(i=e.numberOfUnits),r.push(t)}),this.numberOfUnits=i,this.setMinMaxRooms1(),this.getRoomNums(),this.totalAmount=Math.round(n*this.quantity*100)/100,this.everydayPrices=r,this.reqHotelAvail()}},availMessage:function(e,t){if(e){var a=e.code;1001==a?this.availMessage.message="在代理通这边没有找到酒店信息":1002==a?this.availMessage.message="不是代理通房型":1003==a?this.availMessage.message="子房型信息为空":1004==a?this.availMessage.message="房型售卖规则为空":1005==a?(this.availMessage.message="当前时间不在售卖时间段内",this.dateError="当前时间不在售卖时间段内",this.dialogTableVisible=!0):1006==a?(this.availMessage.message="当前时间不能大于首晚的可预订时间",this.dateError="当前时间不能大于首晚的可预订时间",this.dialogTableVisible=!0):1007==a?(this.availMessage.message="连住天数不符合规则",this.dateError="连住天数不符合规则",this.dialogTableVisible=!0):1008==a?(this.availMessage.message="预定间数不符合规则",this.quantityError="预定间数不符合规则"):1009==a?this.availMessage.message="没找到房价信息":1010==a?this.availMessage.message="没找到采购价信息":1011==a?this.availMessage.message="没找到当日房价信息":1012==a?this.availMessage.message="当日价格或币种不相等":1013==a?this.availMessage.message="没找到房态信息":1014==a?(this.availMessage.message="没找到当日房态信息或当日房态为满房",this.dateError="没找到当日房态信息或当日房态为满房",this.dialogTableVisible=!0):1015==a?(this.availMessage.message="剩余立即确认房量小于可扣减房量",this.quantityError="剩余立即确认房量小于可扣减房量"):1016==a?(this.availMessage.message="总库存剩余房量小于可扣减房量",this.quantityError="总库存剩余房量小于可扣减房量"):1017==a?this.availMessage.message="请求参数不正确":1018==a?this.availMessage.message="透传可定检查不通过":1019==a?this.availMessage.message="未获取到汇率":100035==a?this.availMessage.message="入离日期天数与价格天数不一致":100044==a?this.availMessage.message="价格不能为空":100051==a&&(this.availMessage.message="售卖房型和基础房型不匹配，建议废弃无效该售卖房型，重新获取新静态信息")}},primaryLangID:function(e,t){this.testPhone(),this.testContactPerson(),this.testLastArrivalTime(),this.phoneTechTypes="en"==e?[{phoneTechType:1,name:"Voice call"},{phoneTechType:2,name:"Fax"},{phoneTechType:3,name:"Cell phone"},{phoneTechType:4,name:"E-mail"}]:[{phoneTechType:1,name:"语音电话"},{phoneTechType:2,name:"传真"},{phoneTechType:3,name:"手机"},{phoneTechType:4,name:"邮箱"}]}},computed:c({},Object(l.c)(["primaryLangID"])),created:function(){this.$route.query.hotelID&&this.$route.query.roomID&&this.$route.query.roomTypeID&&this.$route.query.maxAudltOccupancy&&this.$route.query.hoteltype?(this.hotelID=JSON.parse(this.$route.query.hotelID),this.roomTypeID=JSON.parse(this.$route.query.roomTypeID)+"",this.roomID=JSON.parse(this.$route.query.roomID)+"",this.maxAudltOccupancy=JSON.parse(this.$route.query.maxAudltOccupancy)+"",this.roomName=JSON.parse(this.$route.query.roomName),this.saleStatus=JSON.parse(this.$route.query.saleStatus),this.numberOfUnits=JSON.parse(this.$route.query.numberOfUnits),this.minBookRoomCount=1*JSON.parse(this.$route.query.minBookRoomCount),this.minContinueDay=1*JSON.parse(this.$route.query.minContinueDay),this.maxBookRoomCount=1*JSON.parse(this.$route.query.maxBookRoomCount),this.maxContinueDay=1*JSON.parse(this.$route.query.maxContinueDay),this.checkQunarNOLimit=JSON.parse(this.$route.query.checkQunarNOLimit),this.limitDay=JSON.parse(this.$route.query.limitDay),this.limitType=JSON.parse(this.$route.query.limitType),this.limitTime=JSON.parse(this.$route.query.limitTime),this.endTimeType=1*JSON.parse(this.$route.query.endTimeType),this.hoteltype=JSON.parse(this.$route.query.hoteltype),this.setMinMaxRooms(),this.getRoomNums(),this.setStartEndTime()):this.$router.go(-1)},mounted:function(){this.choiceMenuId("hotelList")}},u={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"myHotelOrder"},[a("div",{staticClass:"myOrderDetail-navDiv"},[a("div",{staticClass:"myOrderDetail-breadcrumbDiv"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[e._v(e._s(e.$t("m.hotelManagement")))]),e._v(" "),a("el-breadcrumb-item",{attrs:{to:{name:"hotelList"}}},[e._v(e._s(e.$t("m.hotelList")))]),e._v(" "),a("el-breadcrumb-item",[e._v(e._s(e.$t("m.orderManagement")))])],1)],1),e._v(" "),a("div",{staticClass:"myOrderDetail-bigTitleDiv"},[a("h1",{staticClass:"bigTitle"},[e._v(e._s(e.$t("m.createOrder")))])])]),e._v(" "),a("div",{staticClass:"myHotelOrder-itemDiv"},[a("el-dialog",{attrs:{title:""+e.$t("m.dateChanged"),visible:e.dialogTableVisible,top:"35vh",width:"700px"},on:{"update:visible":function(t){e.dialogTableVisible=t}}},[a("div",{staticStyle:{"text-align":"center"}},[a("div",{staticClass:"mySelectDateDiv"},[a("span",{staticClass:"mySelectDateSpan"},[e._v(e._s(e.$t("m.CheckInDate")))]),e._v(" "),a("el-date-picker",{attrs:{type:"date",placeholder:"en"==e.primaryLangID?"Select a check-in date":"选择入住日期"},model:{value:e.start1,callback:function(t){e.start1=t},expression:"start1"}},[e._v("\n          >\n          ")])],1),e._v(" "),a("div",{staticClass:"mySelectDateDiv",staticStyle:{"margin-right":"5px"}},[a("span",{staticClass:"mySelectDateSpan"},[e._v(e._s(e.$t("m.CheckOutDate")))]),e._v(" "),a("el-date-picker",{attrs:{type:"date",placeholder:"en"==e.primaryLangID?"Select a check-out date":"选择退房日期"},model:{value:e.end1,callback:function(t){e.end1=t},expression:"end1"}})],1)]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.dateError,expression:"dateError"}],staticStyle:{color:"red","text-align":"center","margin-top":"10px"}},[e._v("*"+e._s(e.dateError))]),e._v(" "),a("div",{staticStyle:{"text-align":"center","margin-top":"10px"}},[a("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary",size:"medium"},on:{click:e.toChangeDate}},[e._v(e._s(e.$t("m.confirm")))]),e._v(" "),a("el-button",{attrs:{type:"primary",plain:"",size:"medium"},on:{click:e.cancleChangeDate}},[e._v(e._s(e.$t("m.cancle")))])],1)]),e._v(" "),a("div",{staticClass:"itemDiv"},[a("div",{staticClass:"title"},[e._v("\n        "+e._s(e.$t("m.bookingDetails"))+"\n      ")]),e._v(" "),a("div",{staticClass:"contentDiv"},[a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.roomInformation")))]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[e._v("\n            "+e._s(e.roomName)+"\n          ")])])]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.intoTheFromTime")))]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan1"},[e._v("\n              "+e._s(e.dateToStr(e.start).slice(0,10))+"\n            ")]),e._v(" "),a("span",{staticClass:"infoSpan1",staticStyle:{color:"rgb(153,153,153)"}},[e._v("\n              "+e._s(e.dateToStr(e.start).slice(10,e.dateToStr(e.start).length))+"\n            ")]),e._v(" "),a("span",{staticClass:"infoSpan1"},[e._v("\n            ——\n          ")]),e._v(" "),a("span",{staticClass:"infoSpan1"},[e._v("\n            "+e._s(e.dateToStr(e.end).slice(0,10))+"\n          ")]),e._v(" "),a("span",{staticClass:"infoSpan1",staticStyle:{color:"rgb(153,153,153)"}},[e._v("\n            "+e._s(e.dateToStr(e.end).slice(10,e.dateToStr(e.end).length))+"\n          ")]),e._v(" "),a("el-button",{staticStyle:{"margin-left":"20px"},attrs:{size:"mini"},on:{click:e.openDate}},[e._v(e._s(e.$t("m.dateChanged")))]),e._v(" "),e.checkQunarNOLimit?a("span",{staticClass:"infoTipSpan"},[a("i",{staticClass:"el-icon-warning"}),e._v(" "),a("span",[e._v(e._s(e.formatterRatePlan()))])]):e._e(),e._v(" "),a("span",{directives:[{name:"loading",rawName:"v-loading",value:e.dateLoading,expression:"dateLoading"}],staticClass:"infoSpan1",staticStyle:{color:"rgb(153,153,153)",height:"20px",width:"20px"}})],1)]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.numberOfRooms")))]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("el-select",{attrs:{placeholder:"选择房间数量"},on:{change:function(t){return e.setRoomNum()}},model:{value:e.quantity,callback:function(t){e.quantity=t},expression:"quantity"}},e._l(e.roomNums,function(e){return a("el-option",{key:e.value,attrs:{label:e.value,value:e.value}})}),1),e._v(" "),"zh-cn"==e.primaryLangID?a("span",{staticClass:"infoSpan leftMargin"},[e._v("\n              每间最多"+e._s(e.maxAudltOccupancy)+"人\n            ")]):e._e(),e._v(" "),"en"==e.primaryLangID?a("span",{staticClass:"infoSpan leftMargin"},[e._v("\n              Each room has a maximum of "+e._s(e.maxAudltOccupancy)+" persons\n            ")]):e._e(),e._v(" "),e.quantityError?a("span",{staticClass:"errorInfo"},[e._v("*"+e._s(e.quantityError))]):e._e(),e._v(" "),a("span",{directives:[{name:"loading",rawName:"v-loading",value:e.availLoading,expression:"availLoading"}],staticClass:"infoSpan1",staticStyle:{color:"rgb(153,153,153)",height:"20px",width:"20px"}})],1)]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.roomRate")))]),e._v(" "),e.everydayPrices.length?a("div",{staticClass:"InfoDiv",staticStyle:{"max-width":"900px"}},[e._l(e.everydayPrices,function(t,i){return a("table",{key:i,staticClass:"InfoTable"},[a("tr",[a("th",[e._v(e._s(t.datetime.slice(5,10)))])]),e._v(" "),a("tr",[a("td",[a("div",{staticClass:"InfoPrice"},[e._v(e._s(t.inclusiveAmount)+e._s(" ")+e._s(t.currency))]),e._v(" "),a("div",{staticClass:"InfoMeal"},[a("span",{staticClass:"mealNum"},[e._v(e._s(e.formatterRateMealCount(t)))]),e._v("\n                    "+e._s(e.formatterRateMeal(t))+"\n                  ")])])])])}),e._v(" "),a("table",{staticClass:"InfoTable"},[a("tr",[a("th",[e._v(e._s(e.dateToStr(e.end).slice(5,10)))])]),e._v(" "),a("tr",[a("td",[a("div",{staticClass:"InfoPrice"},[e._v(e._s("-"))]),e._v(" "),a("div",{staticClass:"InfoMeal"},[e._v("\n                    "+e._s("en"==e.primaryLangID?"No meal":"无餐")+"\n                  ")])])])])],2):e._e()])])]),e._v(" "),a("div",{staticClass:"itemDiv"},[a("div",{staticClass:"title"},[e._v("\n        "+e._s(e.$t("m.checkInInformation"))+"\n      ")]),e._v(" "),a("div",{staticClass:"contentDiv"},[e._l(e.persons,function(t,i){return a("div",{key:i,staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v("\n            "+e._s(e.$t("m.room"))+e._s(i+1)+"\n            "),a("span",{staticClass:"personTitle"},[e._v("\n              "+e._s(e.$t("m.lodger"))+"\n            ")])]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[a("el-input",{attrs:{placeholder:"en"==e.primaryLangID?"fill in the name of 1 guest":"每间须填写1名住客姓名",clearable:""},model:{value:t.name,callback:function(a){e.$set(t,"name",a)},expression:"person.name"}})],1),e._v(" "),0==i?a("span",{staticClass:"infoTipSpan"},[a("i",{staticClass:"el-icon-warning"}),e._v(" "),"zh-cn"==e.primaryLangID?a("span",[e._v("所填姓名需与入住时所持证件一致。")]):e._e(),e._v(" "),"en"==e.primaryLangID?a("span",[e._v("The name should be the same as the certificate you hold when you check in")]):e._e(),e._v(" "),a("span",{staticClass:"errorInfo"},[e._v("*海外及港、澳、台酒店姓名按如下格式（姓/名）传：LUO/XIANGANG")])]):e._e()])])}),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.contactName")))]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[a("el-input",{attrs:{placeholder:"en"==e.primaryLangID?"enter the contact name":"请输入联系人名称",clearable:""},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}})],1)])]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.contactPhone")))]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[a("el-input",{attrs:{placeholder:"en"==e.primaryLangID?"enter the contact number":"请输入联系人电话",oninput:"value=value.replace(/[^\\d|-]/g,'')",clearable:""},on:{blur:function(t){return e.testPhone()}},model:{value:e.phone,callback:function(t){e.phone=t},expression:"phone"}})],1),e._v(" "),e.phoneError&&"en"==e.primaryLangID?a("span",{staticClass:"errorInfo"},[e._v("*"+e._s(e.phoneError))]):e._e(),e._v(" "),e.phoneError&&"zh-cn"==e.primaryLangID?a("span",{staticClass:"errorInfo"},[e._v("*"+e._s(e.phoneError))]):e._e()])]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[a("el-select",{attrs:{placeholder:"en"==e.primaryLangID?"other contact":"选择其他联系方式"},on:{change:e.setPhoneNumber},model:{value:e.contactPerson[0].phoneTechType,callback:function(t){e.$set(e.contactPerson[0],"phoneTechType",t)},expression:"contactPerson[0].phoneTechType"}},e._l(e.phoneTechTypes,function(e){return a("el-option",{key:e.phoneTechType,attrs:{label:e.name,value:e.phoneTechType}})}),1)],1),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[a("el-input",{attrs:{placeholder:"en"==e.primaryLangID?"enter the corresponding contact information":"请输入相应联系方式",clearable:""},on:{blur:function(t){return e.testContactPerson()}},model:{value:e.contactPerson[0].phoneNumber,callback:function(t){e.$set(e.contactPerson[0],"phoneNumber",t)},expression:"contactPerson[0].phoneNumber"}})],1),e._v(" "),e.otherError&&"en"==e.primaryLangID?a("span",{staticClass:"errorInfo"},[e._v("*"+e._s(e.otherError))]):e._e(),e._v(" "),e.otherError&&"zh-cn"==e.primaryLangID?a("span",{staticClass:"errorInfo"},[e._v("*"+e._s(e.otherError))]):e._e()])]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v("\n            "+e._s(e.$t("m.theLatestArrivalTime"))+"\n          ")]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[a("el-input",{attrs:{placeholder:"en"==e.primaryLangID?"the local latest arrival time":"请输入最晚到店时间，例如“14：00”",oninput:"value=value.replace(/[^\\d|\\:]/g,'')",clearable:""},on:{blur:function(t){return e.testLastArrivalTime()}},model:{value:e.lastArrivalTime,callback:function(t){e.lastArrivalTime=t},expression:"lastArrivalTime"}})],1),e._v(" "),e.lastArrivalTimeError&&"en"==e.primaryLangID?a("span",{staticClass:"errorInfo"},[e._v("*"+e._s(e.lastArrivalTimeError))]):e._e(),e._v(" "),e.lastArrivalTimeError&&"zh-cn"==e.primaryLangID?a("span",{staticClass:"errorInfo"},[e._v("*"+e._s(e.lastArrivalTimeError))]):e._e(),e._v(" "),a("span",{staticClass:"infoTipSpan"},[a("i",{staticClass:"el-icon-warning"}),e._v(" "),"zh-cn"==e.primaryLangID?a("span",[e._v("填当地最晚到达时间，例如：14:00")]):e._e(),e._v(" "),"en"==e.primaryLangID?a("span",[e._v("Fill in the local latest arrival time,such as 14:00")]):e._e()])])]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v("\n            "+e._s(e.$t("m.remark"))+"\n          ")]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan textareaSpan"},[a("el-input",{attrs:{placeholder:"en"==e.primaryLangID?"You can mark other information":"您可以备注其他信息",type:"textarea",autosize:{minRows:2,maxRows:4}},model:{value:e.remark,callback:function(t){e.remark=t},expression:"remark"}})],1),e._v(" "),a("span",{staticClass:"infoTipSpan"},[a("i",{staticClass:"el-icon-warning"}),e._v(" "),"zh-cn"==e.primaryLangID?a("span",[e._v("若无其他备注信息可不填该项")]):e._e(),e._v(" "),"en"==e.primaryLangID?a("span",[e._v("If there are no other remarks, please do not fill in this item")]):e._e()])])])],2)]),e._v(" "),a("div",{staticClass:"itemDiv"},[a("div",{staticClass:"title"},[e._v("\n        "+e._s(e.$t("m.billingInformation"))+"\n      ")]),e._v(" "),a("div",{staticClass:"contentDiv"},[a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.policies")))]),e._v(" "),e.ratePlans?a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan",staticStyle:{display:"inline-block"}},[e._v("\n              "+e._s(e.formatterRatePlan(e.ratePlans))+"\n            ")])]):e._e(),e._v(" "),e.cancelPenalty?a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[e._v("\n              "+e._s(e.formatterCancelPenalty(e.cancelPenalty,1))+"\n            ")])]):e._e(),e._v(" "),e.cancelPenalty&&e.cancelPenalty.canCancel?a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan"},[e._v("\n              "+e._s(e.formatterCancelPenalty(e.cancelPenalty,2))+"\n            ")])]):e._e()]),e._v(" "),a("div",{staticClass:"item"},[a("span",{staticClass:"titleSpan"},[e._v(e._s(e.$t("m.totalAmount")))]),e._v(" "),a("div",{staticClass:"InfoDiv"},[a("span",{staticClass:"infoSpan",staticStyle:{color:"rgb(251,165,0)","font-size":"18px"}},[e._v("\n              "+e._s(e.totalAmount)+e._s(" ")+e._s(e.currency)+"\n            ")])])])])]),e._v(" "),a("div",{staticClass:"createOrderDiv"},[a("el-button",{attrs:{type:"primary",disabled:!e.status},on:{click:e.createOrder}},[e._v(e._s(e.$t("m.confirmandSubmitOrder")))])],1)],1)])},staticRenderFns:[]};var p=a("VU/8")(h,u,!1,function(e){a("DDe1")},null,null);t.default=p.exports}});