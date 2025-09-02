
@Service
public class JwtService {
    private static final String SECRET = "your_secret_key_base64";

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET)), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET)))
                .build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}