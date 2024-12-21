/*
 * package com.aevum.tec.swagger;
 * 
 * import io.swagger.v3.oas.annotations.Operation; import
 * io.swagger.v3.oas.annotations.Parameter; import
 * io.swagger.v3.oas.annotations.responses.ApiResponse; import
 * io.swagger.v3.oas.annotations.tags.Tag; import
 * org.springframework.web.bind.annotation.*;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/users")
 * 
 * @Tag(name = "User Management", description = "APIs for managing users")
 * public class OpenApiDocController {
 * 
 * @GetMapping("/{id}")
 * 
 * @Operation( summary = "Get User by ID", description =
 * "Fetch a user by their unique ID", responses = {
 * 
 * @ApiResponse(responseCode = "200", description = "User found"),
 * 
 * @ApiResponse(responseCode = "404", description = "User not found") } ) public
 * String getUserById(@PathVariable @Parameter(description =
 * "Unique ID of the user") Long id) { return "User with ID: " + id; }
 * 
 * @PostMapping
 * 
 * @Operation(summary = "Create User", description =
 * "Add a new user to the system") public String
 * createUser(@RequestBody @Parameter(description = "User object to be created")
 * String user) { return "User created: " + user; } }
 */