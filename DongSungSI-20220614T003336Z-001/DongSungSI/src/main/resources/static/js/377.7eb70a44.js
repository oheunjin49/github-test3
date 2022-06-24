"use strict";(self["webpackChunkfront_end"]=self["webpackChunkfront_end"]||[]).push([[377],{6377:function(e,t,a){a.r(t),a.d(t,{default:function(){return u}});var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"container mt-3"},[a("div",{staticClass:"col-md-8"},[a("div",{staticClass:"input-group mb-3"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.searchEmail,expression:"searchEmail"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Search by Email"},domProps:{value:e.searchEmail},on:{input:function(t){t.target.composing||(e.searchEmail=t.target.value)}}}),a("div",{staticClass:"input-group-append"},[a("button",{staticClass:"btn btn-outline-secondary",attrs:{type:"button"},on:{click:function(t){e.page=1,e.retrieveCustomers()}}},[e._v(" Search ")])])])]),a("div",{staticClass:"col-md-12"},[a("div",{staticClass:"mb-3"},[e._v(" Items per Page: "),a("select",{directives:[{name:"model",rawName:"v-model",value:e.pageSize,expression:"pageSize"}],on:{change:[function(t){var a=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.pageSize=t.target.multiple?a:a[0]},function(t){return e.handlePageSizeChange(t)}]}},e._l(e.pageSizes,(function(t){return a("option",{key:t,domProps:{value:t}},[e._v(" "+e._s(t)+" ")])})),0)]),a("b-pagination",{attrs:{"total-rows":e.count,"per-page":e.pageSize,"prev-text":"Prev","next-text":"Next"},on:{change:e.handlePageChange},model:{value:e.page,callback:function(t){e.page=t},expression:"page"}})],1),a("table",{staticClass:"table"},[e._m(0),e._l(e.customers,(function(t,s){return a("tbody",{key:s},[a("tr",[a("td",[e._v(e._s(t.firstName))]),a("td",[e._v(e._s(t.lastName))]),a("td",[e._v(e._s(t.email))]),a("td",[e._v(e._s(t.phone))]),a("td",[a("a",{staticClass:"btn btn-primary",attrs:{href:"/customers/"+t.id}},[e._v(" Edit ")])])])])}))],2)])},r=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("thead",[a("tr",[a("th",{attrs:{scope:"col"}},[e._v("First Name")]),a("th",{attrs:{scope:"col"}},[e._v("Last Name")]),a("th",{attrs:{scope:"col"}},[e._v("Email")]),a("th",{attrs:{scope:"col"}},[e._v("Phone")]),a("th",{attrs:{scope:"col"}},[e._v("Actions")])])])}],n=a(5963),i={name:"customers",data(){return{customers:[],searchEmail:"",page:1,count:0,pageSize:3,pageSizes:[3,6,9]}},methods:{getRequestParams(e,t,a){let s={};return e&&(s["email"]=e),t&&(s["page"]=t-1),a&&(s["size"]=a),s},retrieveCustomers(){const e=this.getRequestParams(this.searchEmail,this.page,this.pageSize);n.Z.getAll(e).then((e=>{const{customers:t,totalItems:a}=e.data;this.customers=t,this.count=a})).catch((e=>{alert(e)}))},handlePageChange(e){this.page=e,this.retrieveCustomers()},handlePageSizeChange(e){this.pageSize=e.target.value,this.page=1,this.retrieveCustomers()}},mounted(){this.retrieveCustomers()}},o=i,l=a(1001),c=(0,l.Z)(o,s,r,!1,null,null,null),u=c.exports},5963:function(e,t,a){var s=a(2327);class r{getAll(e){return s.Z.get("/customers",{params:e})}get(e){return s.Z.get(`/customers/${e}`)}create(e){return s.Z.post("/customers",e)}update(e,t){return s.Z.put(`/customers/${e}`,t)}delete(e){return s.Z.put(`/customers/deletion/${e}`)}}t["Z"]=new r}}]);
//# sourceMappingURL=377.7eb70a44.js.map