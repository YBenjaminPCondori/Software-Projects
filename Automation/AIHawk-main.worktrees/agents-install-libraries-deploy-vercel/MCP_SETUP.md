# AIHawk MCP Integration & Deployment Guide

## Local Setup

Your Python version (3.10) is below the required 3.11+. **Use Docker** for proper setup.

## Docker Setup

### Quick Start

1. **Copy environment file:**
   ```powershell
   Copy-Item .env.example .env
   # Edit .env and add your OPENAI_API_KEY
   ```

2. **Build and run:**
   ```powershell
   docker-compose up -d
   ```

3. **Verify it's running:**
   ```powershell
   docker ps
   docker logs aihawk-mcp-server
   ```

### Access MCP Server
- **HTTP Endpoint:** `http://localhost:8000`
- **Streamable HTTP:** For Claude/Cursor integration

---

## MCP Integration Setup

### For Claude Code (Desktop)

1. **Add MCP configuration to Claude settings:**
   ```bash
   claude mcp add --scope user stealth -- docker exec aihawk-mcp-server python -m aihawk
   ```

   Or manually edit your Claude config (usually at `~/.claude/claude.json`):
   ```json
   {
     "mcpServers": {
       "aihawk": {
         "command": "docker",
         "args": ["exec", "aihawk-mcp-server", "python", "-m", "aihawk"],
         "description": "AIHawk browser automation agent"
       }
     }
   }
   ```

2. **Restart Claude** and AIHawk will be available to Claude Code

### For Cursor IDE

1. Edit `.cursor/rules/cursor.json`:
   ```json
   {
     "mcpServers": {
       "aihawk": {
         "command": "docker",
         "args": ["exec", "aihawk-mcp-server", "python", "-m", "aihawk"]
       }
     }
   }
   ```

2. Restart Cursor

### For Custom AI Assistant Integration

```python
# Use the streamable HTTP transport
import httpx
from mcp.client.stdio import StdioClientTransport

# Connect to Docker MCP server
client = httpx.AsyncClient(base_url="http://localhost:8000")
```

---

## Docker Commands

**Start in background:**
```powershell
docker-compose up -d
```

**View logs:**
```powershell
docker-compose logs -f aihawk-mcp
```

**Stop service:**
```powershell
docker-compose down
```

**Rebuild image (after code changes):**
```powershell
docker-compose build --no-cache
docker-compose up -d
```

**Interactive shell:**
```powershell
docker exec -it aihawk-mcp-server bash
```

---

## Environment Variables

Create `.env` file:
```env
OPENAI_API_KEY=sk-your-key-here
LOG_LEVEL=info
```

---

## Troubleshooting

**"Failed to fetch browsers":**
- Container has limited time to download Playwright browsers
- Pre-built image includes browsers; if missing, rebuild with `--no-cache`

**MCP connection issues:**
- Ensure container is running: `docker ps`
- Check logs: `docker-compose logs`
- Verify port 8000 is available

**Memory issues:**
- Limit Docker memory: Edit `docker-compose.yml` and add under `aihawk-mcp`:
  ```yaml
  deploy:
    resources:
      limits:
        memory: 2G
  ```

---

## Production Deployment

For cloud deployment (AWS, DigitalOcean, etc.):

1. **Push image to registry:**
   ```powershell
   docker build -t your-registry/aihawk-mcp .
   docker push your-registry/aihawk-mcp
   ```

2. **Deploy with volume for persistence:**
   - Ensure `/app/data` volume mounts to persistent storage
   - Set `OPENAI_API_KEY` via environment secrets (not .env)

3. **Add reverse proxy (nginx/Caddy)** for HTTPS on production

---

## References

- [AIHawk GitHub](https://github.com/feder-cr/AIHawk)
- [MCP Documentation](https://modelcontextprotocol.io)
- [Claude Code Integration](https://claude.ai/integrations)
