// 设置jQuery发送Ajax的全局选项
jQuery.ajaxSetup({
	error: function(xhr, textStatus, error){
		alert("服务器交互出现异常，错误信息：" + textStatus);
	}
});
// 创建模块，加载ui.router模块
let app = angular.module("book-app", ['ui.router'])
	// 配置路由，就是配置URL与模板、控制器之间的映射关系
	.config(['$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider){
		// 指定默认重定向到/index地址
		$urlRouterProvider.otherwise('/main');  
		$stateProvider
		// 如果用户请求main路径，使用main.html作为模板
		.state('main', {
			url: '/main',
			templateUrl: 'res/main.html'
		})
		// 如果用户请求/listCategories路径，使用ListCategoriesController控制器和对应模板
		.state('listCategories', {
			url: '/listCategories',
			controller: 'ListCategoriesController',
			templateUrl: 'res/listCategories.html'
		})
		// 如果用户请求/addCategory路径，使用AddCategoryController控制器和对应模板
		.state('addCategory', {
			url: '/addCategory',
			controller: 'AddCategoryController',
			templateUrl: 'res/addCategory.html'
		})
		// 如果用户请求/updateCategory/:category路径，使用UpdateCategoryController控制器和对应模板
		.state('updateCategory', {
			url: '/updateCategory/:category',
			controller: 'UpdateCategoryController',
			templateUrl: 'res/updateCategory.html'
		})
		// 如果用户请求/listBooks路径，使用ListBooksController控制器和对应模板
		.state('listBooks', {
			url: '/listBooks',
			controller: 'ListBooksController',
			templateUrl: 'res/listBooks.html'
		})
		// 如果用户请求/addBook路径，使用AddBookController控制器和对应模板
		.state('addBook', {
			url: '/addBook',
			controller: 'AddBookController',
			templateUrl: 'res/addBook.html'
		})
		// 如果用户请求/updateBook/:book路径，使用UpdateBookController控制器和对应模板
		.state('updateBook', {
			url: '/updateBook/:book',
			controller: 'UpdateBookController',
			templateUrl: 'res/updateBook.html'
		})
		// 如果用户请求/listInVentories路径，使用ListInventoriesController控制器和对应模板
		.state('listInventories', {
			url: '/listInventories',
			controller: 'ListInventoriesController',
			templateUrl: 'res/listInventories.html'
		})
		// 如果用户请求/inventoryBook路径，使用InventoryBookController控制器和对应模板
		.state('inventoryBook', {
			url: '/inventoryBook',
			controller: 'InventoryBookController',
			templateUrl: 'res/inventoryBook.html'
		})
		// 如果用户请求/listSales路径，使用ListSalesController控制器和对应模板
		.state('listSales', {
			url: '/listSales',
			controller: 'ListSalesController',
			templateUrl: 'res/listSales.html'
		})	
		// 如果用户请求/saleBook路径，使用SaleBookController控制器和对应模板
		.state('saleBook', {
			url: '/saleBook',
			controller: 'SaleBookController',
			templateUrl: 'res/saleBook.html'
		});
	}]);
app.controller("MainController", angular.noop);