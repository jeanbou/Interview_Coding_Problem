SELECT SAT.satellite_id FROM public."SATELITE" AS SAT 
INNER JOIN public."PARAMETER" AS PARAM ON SAT.fk_parameter_id = PARAM."Param_ID"
WHERE SAT.orbit = '{MEO}' AND PARAM.tm1_frequency_mhz = 19008