$(function(){
				
	//User4
	$('#btnUser4s').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user4',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
		
	});
	
	$('#btnUser4').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user4/S101',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser4Register').click(function(){
		
		const jsonData = {
			name: '홍길동',
			gender: 'F',
			age: 23,
			addr: '경주시'
		};
		
		$.ajax({
			type: 'POST',
			url: '/Ch10/user4',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser4Modify').click(function(){
		
		const jsonData = {
			name: '홍길동',
			gender: 'F',
			age: 24,
			addr: '경주시'
		};
		
		$.ajax({
			url: '/Ch10/user4',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser4Delete').click(function(){
		
		$.ajax({
			url: '/Ch10/user4/홍길동',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
		
	});
	
	
});	
