-- Exercise 1: Ranking and Window Functions
-- Goal: Use ROW_NUMBER(), RANK(), DENSE_RANK(), OVER(), and PARTITION BY.
-- Scenario: Find the top 3 most expensive products in each category using different ranking functions.

WITH RankedProducts AS (
    SELECT 
        ProductID,
        ProductName,
        Category,
        Price,
        ROW_NUMBER() OVER(PARTITION BY Category ORDER BY Price DESC) as RowNumRank,
        RANK() OVER(PARTITION BY Category ORDER BY Price DESC) as RankRank,
        DENSE_RANK() OVER(PARTITION BY Category ORDER BY Price DESC) as DenseRankRank
    FROM Products
)
SELECT 
    ProductID,
    ProductName,
    Category,
    Price,
    RowNumRank,
    RankRank,
    DenseRankRank
FROM RankedProducts
WHERE DenseRankRank <= 3;
