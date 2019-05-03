new Vue({
   el: '#app',
   data: {
       user: {id:"",username:"aaa",password:"",age:"",sex:"",email:""},
        userList: []
   },
   created: function(){
        this.findAll();
   },
    methods: {
       findAll: function(){
           var _this = this;
           axios.get('/20190503_vuedemo/user/findAll.do').then(function (response) {
               // handle success
               _this.userList = response.data;
           })
           .then(function () {
               // always executed
           });
       },
        findById:function(userid){
            var _this = this;
            axios.get('/20190503_vuedemo/user/findById.do',{params:{id:userid}}).then(function (response) {
                // handle success
                _this.user = response.data;
                $("#myModal").modal("show");
            })
            .then(function () {
                // always executed
            });
        },
        update:function(user){
           var _this = this;
            axios.post('/20190503_vuedemo/user/updateUser.do', _this.user)
                .then(function (response) {
                      _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
});