# SQL verification checklist
- [ ] Execute DDL on a disposable PostgreSQL database.
- [ ] Verify duplicate email/SKU, negative stock, zero price, invalid status and missing foreign key are rejected.
- [ ] Run CRUD and aggregate queries and compare results to the inserted sample rows.
- [ ] Review query plans for the indexed customer/status/date access paths.
- [ ] Record any AI-suggested SQL, accepted/rejected changes and independent verification here only if AI use is permitted by the instructor.
