using EmployeeAPI.Filters;
using EmployeeAPI.Models;
using Microsoft.AspNetCore.Mvc;

namespace EmployeeAPI.Controllers
{
    [ApiController]
    [Route("api/Emp")]
    [CustomAuthFilter]
    public class EmployeeController : ControllerBase
    {
        private static List<Employee> employees = GetStandardEmployeeList();

        private static List<Employee> GetStandardEmployeeList()
        {
            return new List<Employee>()
            {
                new Employee
                {
                    Id = 1,
                    Name = "John",
                    Salary = 50000,
                    Permanent = true,
                    DateOfBirth = new DateTime(1998, 5, 10),

                    Department = new Department
                    {
                        Id = 1,
                        Name = "IT"
                    },

                    Skills = new List<Skill>()
                    {
                        new Skill
                        {
                            Id = 1,
                            Name = "C#"
                        },
                        new Skill
                        {
                            Id = 2,
                            Name = ".NET Core"
                        }
                    }
                },

                new Employee
                {
                    Id = 2,
                    Name = "Priya",
                    Salary = 60000,
                    Permanent = false,
                    DateOfBirth = new DateTime(1999, 8, 15),

                    Department = new Department
                    {
                        Id = 2,
                        Name = "HR"
                    },

                    Skills = new List<Skill>()
                    {
                        new Skill
                        {
                            Id = 3,
                            Name = "Communication"
                        },
                        new Skill
                        {
                            Id = 4,
                            Name = "Recruitment"
                        }
                    }
                }
            };
        }

        [HttpGet]
        [ProducesResponseType(StatusCodes.Status200OK)]
        public ActionResult<List<Employee>> Get()
        {
            return Ok(employees);
        }

        [HttpPost]
        [ProducesResponseType(StatusCodes.Status200OK)]
        public IActionResult Post()
        {
            return Ok("Employee Added");
        }

        [HttpPut]
        [ProducesResponseType(StatusCodes.Status200OK)]
        public IActionResult Put()
        {
            return Ok("Employee Updated");
        }

        [HttpDelete]
        [ProducesResponseType(StatusCodes.Status200OK)]
        public IActionResult Delete()
        {
            return Ok("Employee Deleted");
        }
    }
}