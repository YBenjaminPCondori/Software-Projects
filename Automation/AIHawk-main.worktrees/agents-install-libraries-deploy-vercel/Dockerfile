# Build stage
FROM python:3.13-slim as builder

WORKDIR /app

# Install build dependencies and Playwright system dependencies
RUN apt-get update && apt-get install -y --no-install-recommends \
    build-essential \
    git \
    && rm -rf /var/lib/apt/lists/*

# Copy project
COPY AIHawk-main/ /app/

# Install Python dependencies
RUN pip install --upgrade pip setuptools wheel && \
    pip install -e .

# Runtime stage
FROM python:3.13-slim

WORKDIR /app

# Install Playwright browser dependencies and runtime requirements
RUN apt-get update && apt-get install -y --no-install-recommends \
    libgtk-3-0 \
    libgbm-dev \
    libdri2-0 \
    libxss1 \
    libxrandr2 \
    libxinerama1 \
    libxi6 \
    libxcursor1 \
    libxtst6 \
    libcups2 \
    libxcomposite1 \
    libxdamage1 \
    libxfixes3 \
    libxkbcommon0 \
    libpango-1.0-0 \
    libpango-gobject-0 \
    libatk1.0-0 \
    libatk-bridge2.0-0 \
    libnss3 \
    libnspr4 \
    fonts-dejavu-core \
    fonts-liberation \
    ca-certificates \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Copy installed packages from builder
COPY --from=builder /usr/local/lib/python3.13/site-packages /usr/local/lib/python3.13/site-packages
COPY --from=builder /usr/local/bin /usr/local/bin

# Copy application code
COPY AIHawk-main/ /app/

# Download Playwright browsers
RUN python -m pip install invisible-playwright && \
    uvx invisible-playwright fetch

# Create non-root user for security
RUN useradd -m -u 1000 aihawk && chown -R aihawk:aihawk /app
USER aihawk

# Run AIHawk MCP server
EXPOSE 8000
CMD ["python", "-m", "aihawk"]
