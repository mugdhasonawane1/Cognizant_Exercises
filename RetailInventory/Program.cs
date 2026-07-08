using RetailInventory.Data;
using RetailInventory.Models;

using var context = new AppDbContext();

var electronics = new Category
{
    CategoryName = "Electronics"
};

var groceries = new Category
{
    CategoryName = "Groceries"
};

await context.Categories.AddRangeAsync(electronics, groceries);

var product1 = new Product
{
    ProductName = "Laptop",
    Price = 75000,
    StockQuantity = 10,
    Category = electronics
};

var product2 = new Product
{
    ProductName = "Rice Bag",
    Price = 1200,
    StockQuantity = 50,
    Category = groceries
};

await context.Products.AddRangeAsync(product1, product2);

await context.SaveChangesAsync();

Console.WriteLine("Data inserted successfully!");