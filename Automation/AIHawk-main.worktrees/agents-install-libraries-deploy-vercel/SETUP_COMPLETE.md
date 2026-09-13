# AIHawk Setup - Quick Start Guide

## Status ✅

✅ **Docker & Docker Compose installed**  
✅ **Dockerfile created** (multi-stage optimized build)  
✅ **docker-compose.yml created** (with health checks)  
✅ **MCP integration configured**  
❌ **Docker daemon not running** (start Docker Desktop)

---

## Next Steps

### 1. Start Docker Desktop
- On Windows: Launch **Docker Desktop** from Start menu
- Wait until "Docker is running" appears in system tray

### 2. Copy environment file
```powershell
Copy-Item .env.example .env
```

### 3. Edit `.env` and add your OpenAI API key
```
OPENAI_API_KEY=sk-your-key-here
LOG_LEVEL=info
```

### 4. Build and start the container
```powershell
docker-compose up -d
```

### 5. Verify it's running
```powershell
docker ps
docker-compose logs -f
```

---

## Once Running: MCP Integration

### For Claude Code (Desktop App)

```bash
claude mcp add --scope user stealth -- docker exec aihawk-mcp-server python -m aihawk
```

Or manually in `~/.claude/claude.json`:
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

### For Cursor IDE

Edit `.cursor/rules/cursor.json` (same as above format)

---

## Files Created

- **Dockerfile** - Multi-stage build with Python 3.13 + Playwright
- **docker-compose.yml** - Service definition with health checks  
- **MCP_SETUP.md** - Full integration guide
- **DOCKER_README.md** - Quick command reference
- **.env.example** - Environment template

---

## Troubleshooting

**Docker daemon not running?**
- Windows: Start Docker Desktop from taskbar
- Linux: `sudo systemctl start docker`

**Port 8000 already in use?**
- Edit `docker-compose.yml` and change `8000:8000` to `8001:8000`

**Need to rebuild?**
```powershell
docker-compose down
docker-compose build --no-cache
docker-compose up -d
```

---

## Quick Test

Once container is running:
```powershell
curl http://localhost:8000/health
```

Should return `{"status": "ok"}`
