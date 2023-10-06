$(function(){
				
	//User3
	$('#btnUser3s').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user3',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
		
	});
	
	$('#btnUser3').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user3/S101',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser3Register').click(function(){
		
		const jsonData = {
			id: 's103',
			name: '홍',
			hp: '030-3333-3333',
			age: 33 
		};
		
		$.ajax({
			type: 'POST',
			url: '/Ch10/user3',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser3Modify').click(function(){
		
		const jsonData = {
			id: 's103',
			name: '홍길동',
			hp: '030-3333-3003',
			age: 33
		};
		
		$.ajax({
			url: '/Ch10/user3',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser3Delete').click(function(){
		
		$.ajax({
			url: '/Ch10/user3/s303',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
		
	});
	
	
});	
