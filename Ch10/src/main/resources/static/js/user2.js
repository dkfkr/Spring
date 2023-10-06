$(function(){
				
	//User2
	$('#btnUser2s').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user2',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
		
	});
	
	$('#btnUser2').click(function(){
		
		$.ajax({
			type: 'GET',
			url: '/Ch10/user2/S101',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser2Register').click(function(){
		
		const jsonData = {
			id: 's103',
			name: '홍',
			hp: '020-2222-2222',
			age: 22 
		};
		
		$.ajax({
			type: 'POST',
			url: '/Ch10/user2',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
			
		});
	});
	
	$('#btnUser2Modify').click(function(){
		
		const jsonData = {
			id: 's102',
			name: '홍길동',
			hp: '020-2222-2002',
			age: 23
		};
		
		$.ajax({
			url: '/Ch10/user2',
			type: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
	});
	
	$('#btnUser2Delete').click(function(){
		
		$.ajax({
			url: '/Ch10/user2/s202',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);							
			}
			
		});
		
	});
	
	
});	
