/**
 * 
 */
new Vue({
	el:"#a",
	data:{
		num:'',
		id:'',
		typei:'',
		ordernum:0,
		p:{}
	},
	created:function(){
		this.id = sessionStorage.getItem("id");
		this.typei = sessionStorage.getItem("typei");
		alert(this.id);
		alert(this.typei);
		this.num = location.search.split('=')[1];
		axios.get('http://localhost:8888/products/'+this.num)
		.then(res=>{
			// alert("res");
			if(res.status==200){
				// alert(res.data.result);
				if(res.data.result==true){
					this.p = res.data.data;
					// alert(this.p.name);
				}
			}else{
				alert("네트워크 연결 안됨");
			}
		})
		.catch(error=>{
			alert("error");
			alert(error.response.data);
		})
	},
	methods:{
		
	}
})