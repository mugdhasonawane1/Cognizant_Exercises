using NUnit.Framework;
using CalcLibrary;

namespace CalcLibrary.Tests
{
    [TestFixture]
    public class CalculatorTests
    {
        private Calculator _calculator;

        [SetUp]
        public void Setup()
        {
            // Initialize activities
            _calculator = new Calculator();
        }

        [TearDown]
        public void TearDown()
        {
            // Cleanup activities
            _calculator = null;
        }

        [Test]
        public void Add_ShouldReturnCorrectSum()
        {
            // Arrange
            int a = 10;
            int b = 20;

            // Act
            int result = _calculator.Add(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(30));
        }

        [TestCase(5, 5, 10)]
        [TestCase(-1, 5, 4)]
        [TestCase(0, 0, 0)]
        public void Add_ShouldReturnCorrectSum_WhenGivenParameters(int a, int b, int expected)
        {
            // Act
            int result = _calculator.Add(a, b);

            // Assert
            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        [Ignore("Ignoring this test as per instructions to demonstrate Ignore attribute.")]
        public void Subtract_ShouldReturnCorrectDifference()
        {
            // Act
            int result = _calculator.Subtract(10, 5);

            // Assert
            Assert.That(result, Is.EqualTo(5));
        }
    }
}
