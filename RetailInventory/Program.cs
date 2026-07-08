using Microsoft.EntityFrameworkCore;
using RetailInventory.Data;

using var context = new AppDbContext();

// Retrieve all products
var products = await context.Products.ToListAsync();

Console.WriteLine("All Products");

foreach (var p in products)
{
    Console.WriteLine($"{p.ProductName} - ₹{p.Price}");
}

Console.WriteLine();

// Find by ID
var product = await context.Products.FindAsync(1);

if (product != null)
{
    Console.WriteLine($"Found: {product.ProductName}");
}
else
{
    Console.WriteLine("Product not found.");
}

Console.WriteLine();

// First product with price greater than 50000
var expensive = await context.Products
    .FirstOrDefaultAsync(p => p.Price > 50000);

if (expensive != null)
{
    Console.WriteLine($"Expensive: {expensive.ProductName}");
}
else
{
    Console.WriteLine("No expensive product found.");
}