``` 
Mockup & screenshot generator for AI Indian Lawyer (AIL)

How to use
1. Place all files in a folder named "mockups" (the HTML, CSS, package.json and capture.js).
2. Install dependencies:
   npm install
3. Generate screenshots:
   npm run capture

Output
- ./mockups/screenshots/dashboard.png
- ./mockups/screenshots/query.png
- ./mockups/screenshots/ingest.png

Notes
- Puppeteer downloads a Chromium binary during npm install; ensure network access.
- If Puppeteer fails due to environment (e.g., in some Linux containers), set PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=1 and provide CHROME_PATH pointing to a system Chrome.
- You can also open the HTML files directly in any browser and capture screenshots manually.