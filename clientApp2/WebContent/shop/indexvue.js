new Vue({
	el:"#top", 
	data:{
		id:'',
		pwd:'',
		logstat:true,
		logtypei:'',
		logtypes:'',
		title:'',
		plist:[],
		liststat:false,
		link:'',
	},
	created: function() {
		this.init();
	},
	methods:{
		init:function(){
			this.id = sessionStorage.getItem("id");
			if(this.id!=null){
				this.logstat=false;
				this.liststat=true;
				this.logtypei = sessionStorage.getItem("typei");
				this.logtypes = sessionStorage.getItem("types");
				if(this.logtypei=='0'){
					this.title='모든 상품 목록';
					this.all_list();
					this.link='./details0.html';
				}else{
					this.title='내 상품 목록';
					this.my_list();
					this.link='./details1.html';
				}
			}else{
				this.logstat=true;
				this.liststat=false;
			}
		},
		login:function(){
			axios.get('http://localhost:8888/members',{params:{'id':this.id, 'pwd':this.pwd}})
			.then(res=>{
				if(res.data.result){
					sessionStorage.setItem("id", this.id);
					sessionStorage.setItem("typei", res.data.typei);
					sessionStorage.setItem("types", res.data.types);
					this.init();
				}
			});
		},
		logout:function(){
			sessionStorage.clear();
			this.id='';
			this.pwd='';
			this.logtypei='';
			this.logtypes='';
			this.plist=[];
			this.link='';
			this.init();
		},
		my_list:function(){
			axios.get('http://localhost:8888/products/itemsby/'+this.id)
			.then(res=>{
				if(res.status==200){
					if(res.data.result==true){
						this.plist = res.data.data;
					}
				}else{
					alert("네트워크 연결 안됨");
				}
			})
		},
		all_list:function(){
			axios.get('http://localhost:8888/products')
			.then(res=>{
				if(res.status==200){
					if(res.data.result==true){
						this.plist = res.data.data;
					}
				}else{
					alert("네트워크 연결 안됨");
				}
			})
		},
		go:function(num){
			location.href=this.link+"?num="+num
		}
	}
});
