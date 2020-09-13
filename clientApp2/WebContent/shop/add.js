new Vue({
	el:"#form",
	data:{
		p:{
			name:'',
			price:0,
			amount:0,
			info:'',
			seller:''
		},
		f:null
	},
	created:function(){
		this.p.seller = sessionStorage.getItem("id");
	},
	methods:{
		save:function(){
			const form = new URLSearchParams();
			form.append('p.name', this.p.name);
			form.append('p.price', this.p.price);
			form.append('p.amount', this.p.amount);
			form.append('p.info', this.p.info);
			form.append('p.seller', this.p.seller);
			form.append('f', this.f);
			axios.post('http://localhost:8888/products', form)
			.then(res=>{
				alert(res.status);
				location.href="index.html";
			})
		}
	}
})