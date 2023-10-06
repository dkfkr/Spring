$(function(){
				
	//User1
	$('#btnUser1s').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user1',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
		
	});
	
	$('#btnUser1').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user1/A102',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser1Register').click(function(){
		
		const jsonData = {
			id: 's103',
			name: '홍',
			hp: '010-1111-1222',
			age: 22 
		};
		
		$.ajax({
			type: 'POST',
			url: '/Ch10/user1',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser1Modify').click(function(){
		
		const jsonData = {
			id: 's101',
			name: '홍길동',
			hp: '010-2222-1001',
			age: 23
		};
		
		$.ajax({
			url: '/Ch10/user1',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser1Delete').click(function(){
		
		$.ajax({
			url: '/Ch10/user1/s101',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
		
	});
	
	
});	
