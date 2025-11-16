const puppeteer = require('puppeteer');
const path = require('path');
const fs = require('fs');

(async () => {
  const outDir = path.join(__dirname, 'screenshots');
  if (!fs.existsSync(outDir)) fs.mkdirSync(outDir);

  const pages = [
    { file: 'dashboard.html', out: 'dashboard.png', width: 1200, height: 900 },
    { file: 'query.html', out: 'query.png', width: 1200, height: 1400 },
    { file: 'ingest.html', out: 'ingest.png', width: 1200, height: 1000 },
  ];

  const browser = await puppeteer.launch({ args: ['--no-sandbox','--disable-setuid-sandbox'] });
  try {
    for (const p of pages) {
      const page = await browser.newPage();
      await page.setViewport({ width: p.width, height: p.height });
      const fileUrl = 'file://' + path.join(__dirname, p.file);
      await page.goto(fileUrl, { waitUntil: 'networkidle0' });
      const outPath = path.join(outDir, p.out);
      await page.screenshot({ path: outPath, fullPage: true });
      console.log('Saved', outPath);
      await page.close();
    }
  } finally {
    await browser.close();
  }
})();