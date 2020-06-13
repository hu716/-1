app.controller("ListBooksController", ['$scope', function ($scope){
		$.get("getAllBooks", null , function(data, statusText)
			{
				// 处理异常
				if (data.exception)
				{
					alert("与服务器交互出现异常：" + data.exception);
				}
				else
				{
					// 获取服务器响应，将所有图书赋值给books
					$scope.$apply(function () {
						$scope.books = data;
					});
				}
			});
	}])
	.controller("AddBookController" , ['$scope', function ($scope){
		$.get("getAllCategories", null , function(data, statusText)
			{
				if (data.exception)
				{
					alert("与服务器交互出现异常：" + data.exception);
				}
				else
				{
					$scope.$apply(function () {
						$scope.categories = data;
					});
				}
			});
		$scope.add = function(){
			$.post("addBook" , $(".form-horizontal").serializeArray() , 
				// 指定回调函数
				function(data , statusText)
				{
					if(data.exception)
					{
						alert("与服务器交互出现异常：" + data.exception);
					}
					else if(data.status > 0)
					{
						alert("图书添加成功!");
						// 清空表单的内容
						$(".form-horizontal").get(0).reset();
					}
					else
					{
						alert("图书添加失败！");
					}
				},
				// 指定服务器响应为json
				"json");
			return false;
		}
	}])
	.controller("UpdateBookController" , ['$scope','$state', '$stateParams',
		function ($scope, $state, $stateParams){
		// 获取所有图书种类
		$.get("getAllCategories", null , function(data, statusText)
			{
				if (data.exception)
				{
					alert("与服务器交互出现异常：" + data.exception);
				}
				else
				{
					$scope.$apply(function () {
						$scope.categories = data;
						$scope.book = $.parseJSON( $stateParams.book );
					});
				}
			});	
		$scope.update = function()
		{
			$.post("updateBook" , $(".form-horizontal").serializeArray() , 
					// 指定回调函数
					function(data , statusText)
					{
						if(data.exception)
						{
							alert("与服务器交互出现异常：" + data.exception);
						}
						else if(data.status > 0)
						{
							alert("图书更新成功!");
							// 清空表单的内容
							$(".form-horizontal").get(0).reset();
							$state.go("listBooks");
						}
						else
						{
							alert("图书更新失败！");
						}
					},
					// 指定服务器响应为json
					"json");
				return false; // 阻止默认的提交
		}
	}])