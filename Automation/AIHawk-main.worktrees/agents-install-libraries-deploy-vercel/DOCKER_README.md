# AIHawk MCP Server - Docker Quick Reference

## Essential Commands

```powershell
# Start service
docker-compose up -d

# Check status
docker ps
docker-compose logs -f

# Stop service
docker-compose down

# Restart
docker-compose restart
```

## Integration with Claude

Add to Claude settings:
```bash
claude mcp add --scope user stealth -- docker exec aihawk-mcp-server python -m aihawk
```

## Monitor

**Health check:**
```powershell
curl http://localhost:8000/health
```

**View logs:**
```powershell
docker logs -f aihawk-mcp-server
```

## Configuration

Create `.env` with:
```
OPENAI_API_KEY=sk-your-key
LOG_LEVEL=info
```

**More details:** See `MCP_SETUP.md`
