webpackJsonp([16],{VUeB:function(e,s){},Xaqj:function(e,s,a){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var t=a("Xxa5"),n=a.n(t),r=a("D2Ra");function i(e){return function(){var s=e.apply(this,arguments);return new Promise(function(e,a){return function t(n,r){try{var i=s[n](r),o=i.value}catch(e){return void a(e)}if(!i.done)return Promise.resolve(o).then(function(e){t("next",e)},function(e){t("throw",e)});e(o)}("next")})}}var o={name:"register",data:function(){return{username:"",question:"",answer:"",password:"",password1:"",phone:"",email:"",usernameOk:"",userError:"",emailOk:"",emailError:"",phoneOk:"",phoneError:"",active:0}},mounted:function(){},methods:{next:function(){this.active++},toTwo:function(){var e=this;return i(n.a.mark(function s(){var a,t,r,i,o;return n.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:if(a=e.username,t=e.password,r=e.password1,i=e.usernameOk,o=e.userError,!(a&&t&&r)){s.next=12;break}if("yes"===i||!o){s.next=5;break}return e.message(o,1500,"error"),s.abrupt("return");case 5:if(t===r){s.next=9;break}return e.message("两次密码输入不一致",1500,"error"),e.password1="",s.abrupt("return");case 9:e.next(),s.next=13;break;case 12:e.message("请输入完整信息再注册",1500,"warning");case 13:case"end":return s.stop()}},s,e)}))()},register:function(){var e=this;return i(n.a.mark(function s(){var a,t,i,o,c,l,u,p,m,v,d,f;return n.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:if(a=e.username,t=e.password,i=e.phone,o=e.email,c=e.question,l=e.answer,u=e.emailOk,p=e.phoneOk,m=e.emailError,v=e.phoneError,!(i&&o&&c.trim()&&l.trim())){s.next=19;break}if("yes"!=u||"yes"!=p){s.next=16;break}return(d=new FormData).append("username",a),d.append("password",t),d.append("phone",i),d.append("email",o),d.append("question",c),d.append("answer",l),s.next=12,Object(r.B)(d);case 12:0==(f=s.sent).status?(e.message(f.msg,1500,"success"),console.log(f),e.active=3):e.message(f.msg,1500,"error"),s.next=17;break;case 16:"yes"!==u&&m?e.message(m,1500,"error"):"yes"!==v&&v&&e.message(v,1500,"error");case 17:s.next=20;break;case 19:e.message("请输入完整信息",1500,"warning");case 20:case"end":return s.stop()}},s,e)}))()},ruleUser:function(){var e=this;return i(n.a.mark(function s(){var a,t;return n.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:if(!(a=e.username).trim()){s.next=8;break}return s.next=4,Object(r.c)({str:a,type:"username"});case 4:0==(t=s.sent).status?e.usernameOk="yes":(e.usernameOk="no",e.userError=t.msg,e.message(t.msg,1500,"error")),s.next=9;break;case 8:e.usernameOk="";case 9:case"end":return s.stop()}},s,e)}))()},ruleEmail:function(){var e=this;return i(n.a.mark(function s(){var a,t;return n.a.wrap(function(s){for(;;)switch(s.prev=s.next){case 0:if(a=e.email,/^([a-zA-Z0-9]+[-_\.]?)+@[a-zA-Z0-9]+\.[a-z]+$/.test(a)){s.next=8;break}e.message("邮箱格式不正确",1500,"error"),e.emailError="邮箱格式不正确",e.emailOk="no",s.next=12;break;case 8:return s.next=10,Object(r.c)({str:a,type:"email"});case 10:0==(t=s.sent).status?e.emailOk="yes":(e.emailOk="no",e.emailError=t.msg,e.message(t.msg,1500,"error"));case 12:case"end":return s.stop()}},s,e)}))()},rulePhone:function(){var e=this.phone;/^1[34578]\d{9}$/.test(e)?this.phoneOk="yes":(this.message("手机号码不正确",1500,"error"),this.phoneError="手机号码不正确",this.phoneOk="no")},message:function(e,s,a){this.$message({message:e,duration:s,type:a})}},watch:{username:function(e,s){e.length>12&&(this.message("用户名最多输入12位",1200,"warning"),this.username=e.slice(0,12))}}},c={render:function(){var e=this,s=e.$createElement,a=e._self._c||s;return a("div",{staticClass:"register"},[a("div",{staticClass:"nav"},[a("div",{staticClass:"inner"},[a("router-link",{attrs:{to:{name:"main"}}},[a("div",{staticClass:"logo"},[a("span",[e._v("酒店管理")])])]),e._v(" "),a("span",{staticClass:"find"},[e._v("管 理 员 注 册")]),e._v(" "),a("div",{staticClass:"right"},[a("router-link",{attrs:{to:{name:"login"}}},[a("span",[e._v("登 录")])])],1)],1)]),e._v(" "),a("div",{staticClass:"registerDiv"},[a("div",{staticClass:"find"},[a("el-steps",{attrs:{space:330,active:e.active,"finish-status":"success","align-center":""}},[a("el-step",{attrs:{title:"账号设置"}}),e._v(" "),a("el-step",{attrs:{title:"信息完善"}}),e._v(" "),a("el-step",{attrs:{title:"注册成功"}})],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:0==e.active,expression:"active == 0"}],staticClass:"info"},[a("div",{staticClass:"inputRow"},[a("span",{staticClass:"name"},[e._v("账号：")]),a("el-input",{attrs:{autocomplete:"new-password",placeholder:"请输入您的用户名，最多12位","suffix-icon":e.usernameOk?"yes"==e.usernameOk?"el-icon-circle-check":"el-icon-circle-close":""},on:{blur:e.ruleUser},model:{value:e.username,callback:function(s){e.username=s},expression:"username"}})],1),e._v(" "),a("div",{staticClass:"inputRow"},[a("span",{staticClass:"name"},[e._v("密码：")]),a("el-input",{attrs:{placeholder:"请输入密码",autocomplete:"new-password","show-password":""},model:{value:e.password,callback:function(s){e.password=s},expression:"password"}})],1),e._v(" "),a("div",{staticClass:"inputRow"},[a("span",{staticClass:"name"},[e._v("确认密码：")]),a("el-input",{attrs:{placeholder:"请再次输入密码",autocomplete:"new-password","show-password":""},model:{value:e.password1,callback:function(s){e.password1=s},expression:"password1"}})],1),e._v(" "),a("div",{staticClass:"inputRow"},[a("el-button",{on:{click:e.toTwo}},[e._v("下一步")])],1)]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:1==e.active,expression:"active == 1"}],staticClass:"info"},[a("div",{staticClass:"inputRow"},[a("span",{staticClass:"name"},[e._v("密保问题：")]),a("el-input",{attrs:{placeholder:"请输入密保问题"},model:{value:e.question,callback:function(s){e.question=s},expression:"question"}})],1),e._v(" "),a("div",{staticClass:"inputRow"},[a("span",{staticClass:"name"},[e._v("密保答案：")]),a("el-input",{attrs:{placeholder:"请输入密保答案"},model:{value:e.answer,callback:function(s){e.answer=s},expression:"answer"}})],1),e._v(" "),a("div",{staticClass:"inputRow"},[a("span",{staticClass:"name"},[e._v("手机：")]),a("el-input",{attrs:{"prefix-icon":"el-icon-s-custom",autocomplete:"off",placeholder:"请输入您的手机号","suffix-icon":e.phoneOk?"yes"==e.phoneOk?"el-icon-circle-check":"el-icon-circle-close":""},on:{blur:e.rulePhone},model:{value:e.phone,callback:function(s){e.phone=s},expression:"phone"}})],1),e._v(" "),a("div",{staticClass:"inputRow"},[a("span",{staticClass:"name"},[e._v("邮箱：")]),a("el-input",{attrs:{"prefix-icon":"el-icon-s-custom",autocomplete:"off",placeholder:"请输入您的邮箱","suffix-icon":e.emailOk?"yes"==e.emailOk?"el-icon-circle-check":"el-icon-circle-close":""},on:{blur:e.ruleEmail},model:{value:e.email,callback:function(s){e.email=s},expression:"email"}})],1),e._v(" "),a("div",{staticClass:"inputRow"},[a("el-button",{on:{click:e.register}},[e._v("注 册")])],1)]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:3==e.active,expression:"active == 3"}],staticClass:"info"},[e._m(0),e._v(" "),a("router-link",{attrs:{to:{name:"login"}}},[a("div",{staticClass:"inputRow"},[a("el-button",[e._v("返回登录")])],1)])],1)],1)])])},staticRenderFns:[function(){var e=this.$createElement,s=this._self._c||e;return s("div",{staticClass:"inputRow"},[s("span",{staticClass:"registerSuccess"},[s("i",{staticClass:"el-icon-success"}),this._v("恭喜您，注册成功")])])}]};var l=a("VU/8")(o,c,!1,function(e){a("VUeB")},null,null);s.default=l.exports}});