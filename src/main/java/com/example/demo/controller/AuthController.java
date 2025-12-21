@PostMapping("/register")
public String register(@RequestBody RegisterRequest request) {

    if (request.getPassword() == null || request.getPassword().isBlank()) {
        throw new RuntimeException("Password must not be empty");
    }

    AppUser user = AppUser.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role("ROLE_USER")
            .build();

    userRepository.save(user);

    return "User registered successfully";
}
